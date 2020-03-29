package com.testing;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import com.datageneration.TitleBasics;


public class TitleBasicsTest {
    TitleBasics testInstance;

    @Before
    public void initializeTesting() {
        testInstance = new TitleBasics();
    }

    @Test
    public void checkGetNumberOfRecords() {
        Assert.assertEquals(400000, testInstance.getNumberOfRecords());
    }

    @Test
    public void convertToJsonWithoutNullValues() {
        String[] stringArrayWithoutNullValues = new String[9];
        stringArrayWithoutNullValues[0] = ("tt000001");
        stringArrayWithoutNullValues[1] = ("short");
        stringArrayWithoutNullValues[2] = ("Carmencita");
        stringArrayWithoutNullValues[3] = ("Carmencita");
        stringArrayWithoutNullValues[4] = ("0");
        stringArrayWithoutNullValues[5] = ("1894");
        stringArrayWithoutNullValues[6] = ("1990");
        stringArrayWithoutNullValues[7] = ("1");
        stringArrayWithoutNullValues[8] = ("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(stringArrayWithoutNullValues).toString());
    }

    @Test
    public void convertToJsonWithNullValues() {
        String[] stringArrayWithNullValues = new String[9];
        stringArrayWithNullValues[0] = ("\\N");
        stringArrayWithNullValues[1] = ("\\N");
        stringArrayWithNullValues[2] = ("\\N");
        stringArrayWithNullValues[3] = ("\\N");
        stringArrayWithNullValues[4] = ("\\N");
        stringArrayWithNullValues[5] = ("\\N");
        stringArrayWithNullValues[6] = ("\\N");
        stringArrayWithNullValues[7] = ("\\N");
        stringArrayWithNullValues[8] = ("\\N");

        String correctOutput = "{\"primaryTitle\":null,\"titleType\":null,\"tconst\":null,\"" +
                "originalTitle\":null,\"runTimeMinutes\":null,\"startYear\":null,\"genre\":null,\"" +
                "endYear\":null,\"isAdult\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(stringArrayWithNullValues).toString());
    }
}
