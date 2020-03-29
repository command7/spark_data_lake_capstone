package com.testing;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import com.datageneration.TitleRating;

import java.util.ArrayList;

public class TitleRatingTest {
    TitleRating testInstance;

    @Before
    public void initializeTesting() {
        testInstance = new TitleRating();
    }

    @Test
    public void checkGetNumberOfRecords() {
        Assert.assertEquals(400000, testInstance.getNumberOfRecords());
    }

    @Test
    public void convertToJsonWithoutNullValues() {
        String[] stringArrayWithoutNullValues = new String[3];
        stringArrayWithoutNullValues[0] = ("tt0001");
        stringArrayWithoutNullValues[1] = ("6.1");
        stringArrayWithoutNullValues[2] = ("186.0");

        String correctOutput = "{\"tconst\":\"tt0001\",\"averageRating\":6.1,\"numVotes\":186}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(stringArrayWithoutNullValues).toString());
    }

    @Test
    public void convertToJsonWithNullValues() {
        String[] stringArrayWithNullValues = new String[3];
        stringArrayWithNullValues[0] = ("\\N");
        stringArrayWithNullValues[1] = ("\\N");
        stringArrayWithNullValues[2] = ("\\N");

        String correctOutput = "{\"tconst\":null,\"averageRating\":null,\"numVotes\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(stringArrayWithNullValues).toString());
    }
}
