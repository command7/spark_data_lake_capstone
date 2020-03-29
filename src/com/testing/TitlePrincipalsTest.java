package com.testing;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import com.datageneration.TitlePrincipals;

public class TitlePrincipalsTest {
    TitlePrincipals testInstance;

    @Before
    public void initializeTesting() {
        testInstance = new TitlePrincipals();
    }

    @Test
    public void checkGetNumberOfRecords() {
        Assert.assertEquals(3587674, testInstance.getNumberOfRecords());
    }

    @Test
    public void convertToJsonWithoutNullValues() {
        String[] stringArrayWithoutNullValues = new String[6];
        stringArrayWithoutNullValues[0] = ("tt00001");
        stringArrayWithoutNullValues[1] = ("1");
        stringArrayWithoutNullValues[2] = ("nm1588970");
        stringArrayWithoutNullValues[3] = ("self");
        stringArrayWithoutNullValues[4] = ("director");
        stringArrayWithoutNullValues[5] = ("[Herself]");

        String correctOutput = "{\"characters\":\"[Herself]\",\"tconst\":\"tt00001\",\"ordering\":1,\"nconst\":\"" +
                "nm1588970\",\"category\":\"self\",\"job\":\"director\"}";
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

        String correctOutput = "{\"characters\":null,\"tconst\":null,\"ordering\":null,\"nconst\":" +
                "null,\"category\":null,\"job\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(stringArrayWithNullValues).toString());
    }
}
