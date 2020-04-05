package com.datageneration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehoseClient;
import com.amazonaws.services.kinesisfirehose.model.PutRecordRequest;
import com.amazonaws.services.kinesisfirehose.model.Record;
import org.json.JSONObject;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.*;

public class DataGenerator {

    private BasicAWSCredentials awsCredentials;
    private TitleBasics titleBasicsGenerator;
    private TitlePrincipals titlePrincipalsGenerator;
    private TitleRating titleRatingGenerator;
    private TitleEpisode titleEpisodeGenerator;
    private NameBasic nameBasicGenerator;
    private String titleBasicsDirectoryName;
    private String titlePrincipalsDirectoryName;
    private String titleRatingDirectoryName;
    private String titleEpisodeDirectoryName;
    private String nameBasicsDirectoryName;
    private BufferedWriter titleBasicsWriter;
    private BufferedWriter titlePrincipalsWriter;
    private BufferedWriter titleRatingWriter;
    private BufferedWriter titleEpisodeWriter;
    private BufferedWriter nameBasicWriter;

    private AmazonKinesisFirehose firehoseClient;

    public DataGenerator() {
//        this.initializeFirehoseClient();
        this.initializeDataGenerators();
        this.initializeDirectoryNames();
        this.initializeDirectoryWriters();
    }

    private void initializeDataGenerators() {
        titleBasicsGenerator = new TitleBasics();
        titlePrincipalsGenerator = new TitlePrincipals();
        titleRatingGenerator = new TitleRating();
        nameBasicGenerator = new NameBasic();
        titleEpisodeGenerator = new TitleEpisode();
    }

    public BufferedWriter getTitleBasicsWriter() {
        return titleBasicsWriter;
    }

    public BufferedWriter getTitlePrincipalsWriter() {
        return titlePrincipalsWriter;
    }

    public BufferedWriter getNameBasicWriter() {
        return nameBasicWriter;
    }

    public BufferedWriter getTitleEpisodeWriter() {
        return titleEpisodeWriter;
    }

    public BufferedWriter getTitleRatingWriter() {
        return titleRatingWriter;
    }

    public String getTitleBasicsDirectoryName() {
        return titleBasicsDirectoryName;
    }

    public String getTitlePrincipalsDirectoryName() {
        return titlePrincipalsDirectoryName;
    }

    public String getNameBasicsDirectoryName() {
        return nameBasicsDirectoryName;
    }

    public String getTitleEpisodeDirectoryName() {
        return titleEpisodeDirectoryName;
    }

    public String getTitleRatingDirectoryName() {
        return titleRatingDirectoryName;
    }

    public void setTitleBasicsDirectoryName(String _dirName) {
        this.titleBasicsDirectoryName = _dirName;
    }

    public File getTitlePrincipalsDirectoryAsFile() {
        return new File(this.getTitlePrincipalsDirectoryName());
    }
    public File getTitleBasicsDirectoryAsFile() {
        return new File(this.getTitleBasicsDirectoryName());
    }
    public File getTitleEpisodesDirectoryAsFile() {
        return new File(this.getTitleEpisodeDirectoryName());
    }
    public File getNameBasicsDirectoryAsFile() {
        return new File(this.getNameBasicsDirectoryName());
    }
    public File getTitleRatingsDirectoryAsFile() {
        return new File(this.getTitleRatingDirectoryName());
    }

    public void setTitlePrincipalsDirectoryName (String _dirName) {
        this.titlePrincipalsDirectoryName = _dirName;
    }

    public void setTitleRatingDirectoryName (String _dirName) {
        this.titleRatingDirectoryName = _dirName;
    }

    public void setTitleEpisodeDirectoryName (String _dirName) {
        this.titleEpisodeDirectoryName = _dirName;
    }

    public void setNameBasicsDirectoryName (String _dirName) {
        this.nameBasicsDirectoryName  = _dirName;
    }

    private void initializeDirectoryNames() {
        this.setTitleBasicsDirectoryName("RealTimeData/TitleBasics/titleBasicsData.json");
        this.setTitleEpisodeDirectoryName("RealTimeData/TitleEpisodes/titleEpisodeData.json");
        this.setTitleRatingDirectoryName("RealTimeData/TitleRatings/titleRatingData.json");
        this.setTitlePrincipalsDirectoryName("RealTimeData/TitlePrincipals/titlePrincipalsData.json");
        this.setNameBasicsDirectoryName("RealTimeData/NameBasics/nameBasicsData.json");
    }

    private void initializeTitleBasicsWriter() throws IOException {
        this.titleBasicsWriter = new BufferedWriter(
                new FileWriter(new File(this.getTitleBasicsDirectoryName()), true));
    }

    private void initializeTitleRatingWriter() throws IOException {
        this.titleRatingWriter = new BufferedWriter(
                new FileWriter(new File(this.getTitleRatingDirectoryName()), true));
    }

    private void initializeTitleEpisodeWriter() throws IOException {
        this.titleEpisodeWriter = new BufferedWriter(
                new FileWriter(new File(this.getTitleEpisodeDirectoryName()), true));
    }

    private void initializeTitlePrincipalsWriter() throws IOException {
        this.titlePrincipalsWriter = new BufferedWriter(
                new FileWriter(new File(this.getTitlePrincipalsDirectoryName()), true));
    }

    private void initializeNameBasicsWriter() throws IOException {
        this.nameBasicWriter = new BufferedWriter(
                new FileWriter(new File(this.getNameBasicsDirectoryName()), true));
    }

    private void initializeDirectoryWriters() {
        try {
            this.initializeTitleBasicsWriter();
            this.initializeNameBasicsWriter();
            this.initializeTitleEpisodeWriter();
            this.initializeTitlePrincipalsWriter();
            this.initializeTitleRatingWriter();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
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

    private void initializeFireHoseClient() {
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
        return (int)(Math.random()*((endingNumber -1)+1));
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

    private void writeTitleBasicsDataToDirectory(JSONObject dataToWrite) {
        if (dataToWrite != null) {
            try {
                this.getTitleBasicsWriter().write(dataToWrite.toString());
                this.getTitleBasicsWriter().newLine();
                this.getTitleBasicsWriter().flush();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(7);
            }
        }
    }

    private void writeNameBasicsDataToDirectory(LinkedList<JSONObject> dataToWrite) {
        try {
            for (JSONObject eachDataRecord : dataToWrite) {
                if (eachDataRecord != null) {
                    this.getNameBasicWriter().write(eachDataRecord.toString());
                    this.getNameBasicWriter().newLine();
                    this.getNameBasicWriter().flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(7);
        }
    }

    private void writeTitlePrincipalsDataToDirectory(LinkedList<JSONObject> dataToWrite) {
        try {
            for (JSONObject eachDataRecord : dataToWrite) {
                if (eachDataRecord != null) {
                    this.getTitlePrincipalsWriter().write(eachDataRecord.toString());
                    this.getTitlePrincipalsWriter().newLine();
                    this.getTitlePrincipalsWriter().flush();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(7);
        }
    }

    private void writeTitleRatingDataToDirectory(JSONObject dataToWrite) {
        if (dataToWrite != null) {
            try {
                this.getTitleRatingWriter().write(dataToWrite.toString());
                this.getTitleRatingWriter().newLine();
                this.getTitleRatingWriter().flush();
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(7);
            }
        }
    }

    private void writeTitleEpisodeDataToDirectory(JSONObject dataToWrite) {
        if (dataToWrite != null) {
            try {
                this.getTitleEpisodeWriter().write(dataToWrite.toString());
                this.getTitleEpisodeWriter().newLine();
                this.getTitleEpisodeWriter().flush();
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(7);
            }
        }
    }

    public void processDataForTitleId(String titleIdToProcess) {
        if (titleIdToProcess != null) {
            JSONObject titleBasicsDataToProcess = this.generateTitleBasicsData(titleIdToProcess);
            LinkedList<JSONObject> titlePrincipalsDataToProcess = this.generateTitlePrincipalsData(titleIdToProcess);
            JSONObject titleRatingDataToProcess = this.generateTitleRatingData(titleIdToProcess);
            LinkedList<JSONObject> nameBasicsDataToProcess = this.generateNameBasicData(titleIdToProcess);
            JSONObject titleEpisodeDataToProcess = this.generateTitleEpisodeData(titleIdToProcess);

            System.out.println("\n" + titleIdToProcess);


            System.out.println("TitleBasics :");
            if (titleBasicsDataToProcess != null) {
                System.out.println(titleBasicsDataToProcess.toString());
            } else {
                System.out.println("Null");
            }
            System.out.println("TitleRating :");
            if (titleRatingDataToProcess != null) {
                System.out.println(titleRatingDataToProcess.toString());
            } else {
                System.out.println("Null");
            }
            System.out.println("TitleEpisode :");
            if (titleEpisodeDataToProcess != null) {
                System.out.println(titleEpisodeDataToProcess.toString());
            } else {
                System.out.println("Null");
            }
            System.out.println("Title Principals");
            for (JSONObject dataToProcess : titlePrincipalsDataToProcess) {
                if (dataToProcess != null) {
                    System.out.println(dataToProcess.toString());
                } else {
                    System.out.println("Null");
                }
            }
            System.out.println("NameBasics");
            for (JSONObject dataToProcess : nameBasicsDataToProcess) {
                if (dataToProcess != null) {
                    System.out.println(dataToProcess.toString());
                } else {
                    System.out.println("Null");
                }
            }
            System.out.println("\n\n");
            this.writeTitleBasicsDataToDirectory(titleBasicsDataToProcess);
            this.writeTitlePrincipalsDataToDirectory(titlePrincipalsDataToProcess);
            this.writeTitleRatingDataToDirectory(titleRatingDataToProcess);
            this.writeNameBasicsDataToDirectory(nameBasicsDataToProcess);
            this.writeTitleEpisodeDataToDirectory(titleEpisodeDataToProcess);

            DataStats.deleteIdFromDatabase(titleIdToProcess);
        }
    }

    private void deleteFilesInDirectory(File directoryToEmpty) throws IOException{
        if (directoryToEmpty.isDirectory()) {
            for (File fileInDirectory : directoryToEmpty.listFiles()) {
                System.out.println(fileInDirectory.getAbsolutePath());
                deleteFilesInDirectory(fileInDirectory);
            }
        }
        else
            directoryToEmpty.delete();
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

    public void startFromScratch() {
//        try {
//            this.deleteFilesInDirectory(this.getTitleBasicsDirectoryAsFile());
//            this.deleteFilesInDirectory(this.getNameBasicsDirectoryAsFile());
//            this.deleteFilesInDirectory(this.getTitleEpisodesDirectoryAsFile());
//            this.deleteFilesInDirectory(this.getTitlePrincipalsDirectoryAsFile());
//            this.deleteFilesInDirectory(this.getTitleRatingsDirectoryAsFile());
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
        DataStats.resetDb();
        start();
    }

    public static void main(String[] args) {
//        Instant loadingStart = Instant.now();
        DataGenerator realTimeDataGenerator = new DataGenerator();
        DataStats.resetDb();
        realTimeDataGenerator.start();
//        tt0054477
//        Instant loadingEnd = Instant.now();
//        Duration loadingInterval = Duration.between(loadingStart, loadingEnd);
//        System.out.println("Load completed in " + loadingInterval.getSeconds());
//        test.processDataForTitleId("tt0041951");
//        Instant topFetchStart = Instant.now();
//        test.processDataForTitleId("tt0044093");
//        Instant topFetchEnd = Instant.now();
//        Duration topFetchInterval = Duration.between(topFetchStart, topFetchEnd);
//        System.out.println("Top Fetch completed in " + topFetchInterval.getSeconds());
//        Instant bottomFetchStart = Instant.now();
//        test.processDataForTitleId("tt0949232");
//        Instant bottomFetchEnd = Instant.now();
//        Duration bottomFetchInterval = Duration.between(bottomFetchStart, bottomFetchEnd);
//        System.out.println("Bottom Fetch completed in " + bottomFetchInterval.getSeconds());
    }

}
