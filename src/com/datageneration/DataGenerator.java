package com.datageneration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehoseClient;
import com.amazonaws.services.kinesisfirehose.model.PutRecordRequest;
import com.amazonaws.services.kinesisfirehose.model.Record;
import org.json.JSONObject;

import java.nio.ByteBuffer;
import java.util.ArrayList;

public class DataGenerator {

    public DataGenerator() {
        TitleRating titleRating = new TitleRating("tt0000001");
        ArrayList<JSONObject> titleRatingData = titleRating.getDataAsJson();

//        BasicAWSCredentials awsCredentials = new BasicAWSCredentials("AKIA2ITTLRCLAS6HD47D",
//                "sgeYc4G/e6W+8TD9yGQX12vx+XPfN6d+ECvhvUeRfXlFAtb1");
//
//        AmazonKinesisFirehose firehoseClient = AmazonKinesisFirehoseClient
//                .builder()
//                .withRegion(Regions.US_EAST_1)
//                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
//                .build();
//
//        PutRecordRequest putRecordRequest = new PutRecordRequest();
//        putRecordRequest.setDeliveryStreamName("imdb_data");
//
//        for(int dataIndex = 0; dataIndex < titleRatingData.size(); dataIndex++) {
//            JSONObject jsonRowData = titleRatingData.get(dataIndex);
//            Record record = new Record().withData(ByteBuffer.wrap(jsonRowData.toString().getBytes()));
//            putRecordRequest.setRecord(record);
//            firehoseClient.putRecord(putRecordRequest);
//        }

        System.out.println(titleRating);
    }

    public static void main(String[] args) {
        DataGenerator testGen = new DataGenerator();
    }

}
