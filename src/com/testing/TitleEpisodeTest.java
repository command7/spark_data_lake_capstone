package com.testing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import com.datageneration.TitleEpisode;

public class TitleEpisodeTest {
    TitleEpisode testInstance;

    @Before
    public void initializeTesting() {
        testInstance = new TitleEpisode();
    }

    @Test
    public void checkGetNumberOfRecords() {
        Assert.assertEquals(148698, testInstance.getNumberOfRecords());
    }

    @Test
    public void convertToJsonWithoutNullValues() {
        String[] stringArrayWithoutNullValues = new String[4];
        stringArrayWithoutNullValues[0] = ("tt00001");
        stringArrayWithoutNullValues[1] = ("tt0041038");
        stringArrayWithoutNullValues[2] = ("1");
        stringArrayWithoutNullValues[3] = ("9");

        String correctOutput = "{\"tconst\":\"tt00001\",\"seasonNumber\":1,\"" +
                "episodeNumber\":9,\"parentTconst\":\"tt0041038\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(stringArrayWithoutNullValues).toString());
    }

    @Test
    public void convertToJsonWithNullValues() {
        String[] stringArrayWithNullValues = new String[4];
        stringArrayWithNullValues[0] = ("\\N");
        stringArrayWithNullValues[1] = ("\\N");
        stringArrayWithNullValues[2] = ("\\N");
        stringArrayWithNullValues[3] = ("\\N");

        String correctOutput = "{\"tconst\":null,\"seasonNumber\":null,\"" +
                "episodeNumber\":null,\"parentTconst\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(stringArrayWithNullValues).toString());
    }
}
