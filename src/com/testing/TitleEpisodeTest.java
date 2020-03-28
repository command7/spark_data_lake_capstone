package com.testing;

import com.datageneration.TitlePrincipals;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import com.datageneration.TitleEpisode;

public class TitleEpisodeTest {
    TitleEpisode testInstance;

    @Before
    public void initializeTesting() {
        testInstance = new TitleEpisode();
    }

    @Test
    public void convertToJsonTconstNull() {
        ArrayList<String> nullInTconst = new ArrayList<>();
        nullInTconst.add("\\N");
        nullInTconst.add("tt0041038");
        nullInTconst.add("1");
        nullInTconst.add("9");

        String correctOutput = "{\"tconst\":null,\"seasonNumber\":1,\"" +
                "episodeNumber\":9,\"parentTconst\":\"tt0041038\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTconst).toString());
    }

    @Test
    public void convertToJsonParentTconstNull() {
        ArrayList<String> nullInParentTconst = new ArrayList<>();
        nullInParentTconst.add("tt0041951");
        nullInParentTconst.add("\\N");
        nullInParentTconst.add("1");
        nullInParentTconst.add("9");

        String correctOutput = "{\"tconst\":\"tt0041951\",\"seasonNumber\":1,\"" +
                "episodeNumber\":9,\"parentTconst\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInParentTconst).toString());
    }

    @Test
    public void convertToJsonSeasonNumberNull() {
        ArrayList<String> nullInSeasonNumber = new ArrayList<>();
        nullInSeasonNumber.add("tt0041951");
        nullInSeasonNumber.add("tt0041038");
        nullInSeasonNumber.add("\\N");
        nullInSeasonNumber.add("9");

        String correctOutput = "{\"tconst\":\"tt0041951\",\"seasonNumber\":null,\"" +
                "episodeNumber\":9,\"parentTconst\":\"tt0041038\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInSeasonNumber).toString());
    }

    @Test
    public void convertToJsonEpisodeNumberNull() {
        ArrayList<String> nullInEpisodeNumber = new ArrayList<>();
        nullInEpisodeNumber.add("tt0041951");
        nullInEpisodeNumber.add("tt0041038");
        nullInEpisodeNumber.add("1");
        nullInEpisodeNumber.add("\\N");

        String correctOutput = "{\"tconst\":\"tt0041951\",\"seasonNumber\":1,\"" +
                "episodeNumber\":null,\"parentTconst\":\"tt0041038\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInEpisodeNumber).toString());
    }

    @Test
    public void checkGetNumberOfRecords() {
        Assert.assertEquals(testInstance.getNumberOfRecords(), 444251);
    }
}
