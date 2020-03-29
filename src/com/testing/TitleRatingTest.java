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
        Assert.assertEquals(testInstance.getNumberOfRecords(), 976509);
    }

    @Test
    public void convertToJsonTconstNull() {
        String[] nullInTconst = new String[3];
        nullInTconst[0] = ("\\N");
        nullInTconst[1] = ("6.1");
        nullInTconst[2] = ("186.0");

        String correctOutput = "{\"tconst\":null,\"averageRating\":6.1,\"numVotes\":186}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTconst).toString());
    }

    @Test
    public void convertToJsonTAverageRatingNull() {
        String[] nullInAverageRating = new String[3];
        nullInAverageRating[0] = ("tt0000002");
        nullInAverageRating[1] = ("\\N");
        nullInAverageRating[2] = ("186.0");

        String correctOutput = "{\"tconst\":\"tt0000002\",\"averageRating\":null,\"numVotes\":186}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInAverageRating).toString());
    }

    @Test
    public void convertToJsonNumVotesNull() {
        String[] nullInNumVotes = new String[3];
        nullInNumVotes[0] = ("tt0000002");
        nullInNumVotes[1] = ("6.1");
        nullInNumVotes[2] = ("\\N");

        String correctOutput = "{\"tconst\":\"tt0000002\",\"averageRating\":6.1,\"numVotes\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInNumVotes).toString());
    }
}
