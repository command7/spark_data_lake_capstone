package com.testing;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehose;
import com.amazonaws.services.kinesisfirehose.AmazonKinesisFirehoseClient;
import com.amazonaws.services.kinesisfirehose.model.PutRecordRequest;
import com.amazonaws.services.kinesisfirehose.model.Record;

import java.nio.ByteBuffer;

import org.json.JSONObject;

public class FirehosePutRequest {
    public static void main(String [] args) {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials("AKIA2ITTLRCLIGSG7TPE",
                "sgeYc4G/948Zco2GWDE2PWEhdegHxfZYm4DyWS8V");

        AmazonKinesisFirehose firehoseClient = AmazonKinesisFirehoseClient
                .builder()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();

        PutRecordRequest putRecordRequest = new PutRecordRequest();
        putRecordRequest.setDeliveryStreamName("imdb_data");

        JSONObject messageJson = new JSONObject();
        messageJson.put("key1", "We are testing Amazon Kinesis Firehose!");
        messageJson.put("integerKey", 123);
        messageJson.put("booleanKey", true);
        messageJson.put("anotherString", "This should work!");
        String data = "First try" + "\n";

        Record record = new Record().withData(ByteBuffer.wrap(messageJson.toString().getBytes()));
        putRecordRequest.setRecord(record);

        firehoseClient.putRecord(putRecordRequest);
    }

}
