package com.testing;

import com.datageneration.NameBasic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class NameBasicsTest {
    NameBasic testInstance;

    @Before
    public void initializeTesting() {
        testInstance = new NameBasic();
    }

    @Test
    public void checkGetNumberOfRecords() {
        Assert.assertEquals(1494835, testInstance.getNumberOfRecords());
    }

    @Test
    public void convertToJsonWithoutNullValues() {
        String[] stringArrayWithoutNullValues = new String[6];
        stringArrayWithoutNullValues[0] = ("nm123");
        stringArrayWithoutNullValues[1] = ("Georges Méliès");
        stringArrayWithoutNullValues[2] = ("1861");
        stringArrayWithoutNullValues[3] = ("1938");
        stringArrayWithoutNullValues[4] = ("director,actor,producer");
        stringArrayWithoutNullValues[5] = ("tt0000091,tt0000499,tt0002113,tt0223267");

        String correctOutput = "{\"birthYear\":1861,\"deathYear\":1938,\"primaryProfession\":" +
                "\"director,actor,producer\",\"nconst\":\"nm123\"," +
                "\"knownForTitles\":\"tt0000091,tt0000499,tt0002113,tt0223267\",\"primaryName\":\"Georges Méliès\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(stringArrayWithoutNullValues).toString());
    }

    @Test
    public void convertToJsonWithNullValues() {
        String[] stringArrayWithNullValues = new String[6];
        stringArrayWithNullValues[0] = ("\\N");
        stringArrayWithNullValues[1] = ("\\N");
        stringArrayWithNullValues[2] = ("\\N");
        stringArrayWithNullValues[3] = ("\\N");
        stringArrayWithNullValues[4] = ("\\N");
        stringArrayWithNullValues[5] = ("\\N");

        String correctOutput = "{\"birthYear\":null,\"deathYear\":null,\"primaryProfession\":" +
                "null,\"nconst\":null,\"knownForTitles\":null,\"primaryName\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(stringArrayWithNullValues).toString());
    }
}
