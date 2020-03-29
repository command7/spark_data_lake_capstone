package com.datageneration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehoseClient;
import com.amazonaws.services.kinesisfirehose.model.PutRecordRequest;
import com.amazonaws.services.kinesisfirehose.model.Record;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Properties;

public class DataGenerator {

    private BasicAWSCredentials awsCredentials;
    private TitleBasics titleBasicsGenerator;
    private TitlePrincipals titlePrincipalsGenerator;
    private TitleRating titleRatingGenerator;
    private TitleEpisode titleEpisodeGenerator;
    private NameBasic nameBasicGenerator;

    private AmazonKinesisFirehose firehoseClient;

    public DataGenerator() {
        this.initializeFirehoseClient();
        this.initializeDataGenerators();
    }

    private void initializeDataGenerators() {
        titleBasicsGenerator = new TitleBasics();
        titlePrincipalsGenerator = new TitlePrincipals();
        titleRatingGenerator = new TitleRating();
        nameBasicGenerator = new NameBasic();
        titleEpisodeGenerator = new TitleEpisode();
    }

    private BasicAWSCredentials getAwsCredentials() {
        return this.awsCredentials;
    }

    private AmazonKinesisFirehose getFirehoseClient() {
        return this.firehoseClient;
    }

    public TitleBasics getTitleBasicsGenerator() {
        return titleBasicsGenerator;
    }

    public NameBasic getNameBasicGenerator() {
        return nameBasicGenerator;
    }

    public TitleEpisode getTitleEpisodeGenerator() {
        return titleEpisodeGenerator;
    }

    public TitlePrincipals getTitlePrincipalsGenerator() {
        return titlePrincipalsGenerator;
    }

    public TitleRating getTitleRatingGenerator() {
        return titleRatingGenerator;
    }

    private void initializeFirehoseClient() {
        Properties awsProperties = new Properties();
        try {
            FileInputStream propertyReader = new FileInputStream("awsProperties.properties");
            awsProperties.load(propertyReader);
            propertyReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        awsCredentials = new BasicAWSCredentials(awsProperties.getProperty("accessKey"),
                awsProperties.getProperty("secretKey"));
        firehoseClient = AmazonKinesisFirehoseClient.builder()
                        .withRegion(Regions.US_EAST_1)
                        .withCredentials(new AWSStaticCredentialsProvider(this.getAwsCredentials()))
                        .build();
        awsProperties.clear();
    }

    public int getRandomNumber() {
       int endingNumber = DataStats.getRemainingRecords();
        return (int)(Math.random()*((endingNumber)+1));
    }

    public String getTitleToProcess() {
        int idIndex = getRandomNumber();
        return DataStats.getIdAtIndex(idIndex);
    }

    private JSONObject generateTitleBasicsData(String uniqueId) {
        return this.getTitleBasicsGenerator().getSingleRecordAsJson(uniqueId);
    }

    private LinkedList<JSONObject> generateNameBasicData(String uniqueId) {
        return this.getNameBasicGenerator().getAllRecordsForTitleAsJson(uniqueId);
    }

    private JSONObject generateTitleRatingData(String uniqueId) {
        return this.getTitleRatingGenerator().getSingleRecordAsJson(uniqueId);
    }

    private JSONObject generateTitleEpisodeData(String uniqueId) {
        return this.getTitleEpisodeGenerator().getSingleRecordAsJson(uniqueId);
    }

    private LinkedList<JSONObject> generateTitlePrincipalsData(String uniqueId) {
        return this.getTitlePrincipalsGenerator().getAllRecordsForTitleAsJson(uniqueId);
    }

    public void sendDataToStream(ArrayList<JSONObject> dataRecords,
                                 String streamName) {
        for (JSONObject jsonRowData: dataRecords) {
            PutRecordRequest putRecordRequest = new PutRecordRequest();
            putRecordRequest.setDeliveryStreamName(streamName);
            Record record = new Record().withData(ByteBuffer.wrap(jsonRowData.toString().getBytes()));
            putRecordRequest.setRecord(record);
            this.getFirehoseClient().putRecord(putRecordRequest);
        }
    }

    public void sendDataToStream(LinkedList<JSONObject> dataRecords,
                                 String streamName)  {
        ListIterator<JSONObject> dataListIterator = dataRecords.listIterator();
        while(dataListIterator.hasNext()){
            JSONObject jsonRowData = dataListIterator.next();
            PutRecordRequest putRecordRequest = new PutRecordRequest();
            putRecordRequest.setDeliveryStreamName(streamName);
            Record record = new Record().withData(ByteBuffer.wrap(jsonRowData.toString().getBytes()));
            putRecordRequest.setRecord(record);
            this.getFirehoseClient().putRecord(putRecordRequest);
        }
    }

    public void sendDataToStream(JSONObject dataRecord,
                                 String streamName) {
        if (dataRecord != null) {
            PutRecordRequest putRecordRequest = new PutRecordRequest();
            putRecordRequest.setDeliveryStreamName(streamName);
            Record record = new Record().withData(ByteBuffer.wrap(dataRecord.toString().getBytes()));
            putRecordRequest.setRecord(record);
            this.getFirehoseClient().putRecord(putRecordRequest);
        }
    }

    public void processDataForTitleId(String titleIdToProcess) {
        JSONObject titleBasicsDataToProcess = this.generateTitleBasicsData(titleIdToProcess);
        LinkedList<JSONObject> titlePrincipalsDataToProcess = this.generateTitlePrincipalsData(titleIdToProcess);
        JSONObject titleRatingDataToProcess = this.generateTitleRatingData(titleIdToProcess);
        LinkedList<JSONObject> nameBasicsDataToProcess = this.generateNameBasicData(titleIdToProcess);
        JSONObject titleEpisodeDataToProcess = this.generateTitleEpisodeData(titleIdToProcess);

        this.sendDataToStream(titleBasicsDataToProcess, "title_basics");
        this.sendDataToStream(titlePrincipalsDataToProcess, "title_principals");
        this.sendDataToStream(nameBasicsDataToProcess, "name_basics");
        this.sendDataToStream(titleRatingDataToProcess, "title_ratings");
        this.sendDataToStream(titleEpisodeDataToProcess, "title_episodes");

        DataStats.deleteIdFromDatabase(titleIdToProcess);
    }

    public void start(int numRecordsToProcess) {
        for (int recordCount = 0; recordCount < numRecordsToProcess; recordCount++) {
            String currentTitleId = this.getTitleToProcess();
            this.processDataForTitleId(currentTitleId);
        }
    }

    public void start() {
        int remainingRecords = DataStats.getRemainingRecords();
        while (remainingRecords > 0) {
            String currentTitleId = this.getTitleToProcess();
            this.processDataForTitleId(currentTitleId);
            remainingRecords = DataStats.getRemainingRecords();
        }
    }

    public static void main(String[] args) {
        DataGenerator test = new DataGenerator();
        test.processDataForTitleId("tt0000001");
        test.processDataForTitleId("tt0041951");
        test.processDataForTitleId("tt0044093");
    }

}
