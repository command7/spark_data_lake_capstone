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
import java.util.Properties;

public class DataGenerator {

    private BasicAWSCredentials awsCredentials;

    private AmazonKinesisFirehose firehoseClient;

    public DataGenerator() {
        this.initializeFirehoseClient();
    }

    private BasicAWSCredentials getAwsCredentials() {
        return this.awsCredentials;
    }

    private AmazonKinesisFirehose getFirehoseClient() {
        return this.firehoseClient;
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

    public void processDataForTitleId(String titleIdToProcess) {
        TitleBasics titleBasicsTest = new TitleBasics(titleIdToProcess);
        ArrayList<JSONObject> titleBasicsData = titleBasicsTest.getDataAsJson();

        TitlePrincipals titlePrincipalsTest = new TitlePrincipals(titleIdToProcess);
        ArrayList<JSONObject> titlePrincipalsData = titlePrincipalsTest.getDataAsJson();

        TitleRating titleRatingTest = new TitleRating(titleIdToProcess);
        ArrayList<JSONObject> titleRatingData = titleRatingTest.getDataAsJson();

        NameBasics nameBasicsTest = new NameBasics(titleIdToProcess);
        ArrayList<JSONObject> nameBasicsData = nameBasicsTest.getDataAsJson();

        TitleEpisode titleEpisodeEntity = new TitleEpisode(titleIdToProcess);
        ArrayList<JSONObject> titleEpisodeData = titleEpisodeEntity.getDataAsJson();

        this.sendDataToStream(titleBasicsData, "title_basics");
        this.sendDataToStream(titlePrincipalsData, "title_principals");
        this.sendDataToStream(nameBasicsData, "name_basics");
        this.sendDataToStream(titleRatingData, "title_ratings");
        this.sendDataToStream(titleEpisodeData, "title_episodes");

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
        test.processDataForTitleId("tt0000002");
    }

}
