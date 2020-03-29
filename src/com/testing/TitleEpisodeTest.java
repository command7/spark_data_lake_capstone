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
    public void checkGetNumberOfRecords() {
        Assert.assertEquals(testInstance.getNumberOfRecords(), 444251);
    }

    @Test
    public void convertToJsonTconstNull() {
        String[] nullInTconst = new String[4];
        nullInTconst[0] = ("\\N");
        nullInTconst[1] = ("tt0041038");
        nullInTconst[2] = ("1");
        nullInTconst[3] = ("9");

        String correctOutput = "{\"tconst\":null,\"seasonNumber\":1,\"" +
                "episodeNumber\":9,\"parentTconst\":\"tt0041038\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTconst).toString());
    }

    @Test
    public void convertToJsonParentTconstNull() {
        String[] nullInParentTconst = new String[4];
        nullInParentTconst[0] = ("tt0041951");
        nullInParentTconst[1] = ("\\N");
        nullInParentTconst[2] = ("1");
        nullInParentTconst[3] = ("9");

        String correctOutput = "{\"tconst\":\"tt0041951\",\"seasonNumber\":1,\"" +
                "episodeNumber\":9,\"parentTconst\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInParentTconst).toString());
    }

    @Test
    public void convertToJsonSeasonNumberNull() {
        String[] nullInSeasonNumber = new String[4];
        nullInSeasonNumber[0] = ("tt0041951");
        nullInSeasonNumber[1] = ("tt0041038");
        nullInSeasonNumber[2] = ("\\N");
        nullInSeasonNumber[3] = ("9");

        String correctOutput = "{\"tconst\":\"tt0041951\",\"seasonNumber\":null,\"" +
                "episodeNumber\":9,\"parentTconst\":\"tt0041038\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInSeasonNumber).toString());
    }

    @Test
    public void convertToJsonEpisodeNumberNull() {
        String[] nullInEpisodeNumber = new String[4];
        nullInEpisodeNumber[0] = ("tt0041951");
        nullInEpisodeNumber[1] = ("tt0041038");
        nullInEpisodeNumber[2] = ("1");
        nullInEpisodeNumber[3] = ("\\N");

        String correctOutput = "{\"tconst\":\"tt0041951\",\"seasonNumber\":1,\"" +
                "episodeNumber\":null,\"parentTconst\":\"tt0041038\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInEpisodeNumber).toString());
    }
}
