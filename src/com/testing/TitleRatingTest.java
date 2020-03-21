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
    public void convertToJsonTconstNull() {
        ArrayList<String> nullInTconst = new ArrayList<>();
        nullInTconst.add("\\N");
        nullInTconst.add("6.1");
        nullInTconst.add("186.0");

        String correctOutput = "{\"tconst\":null,\"averageRating\":6.1,\"numVotes\":186}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTconst).toString());
    }

    @Test
    public void convertToJsonTAverageRatingNull() {
        ArrayList<String> nullInAverageRating = new ArrayList<>();
        nullInAverageRating.add("tt0000002");
        nullInAverageRating.add("\\N");
        nullInAverageRating.add("186.0");

        String correctOutput = "{\"tconst\":\"tt0000002\",\"averageRating\":null,\"numVotes\":186}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInAverageRating).toString());
    }

    @Test
    public void convertToJsonNumVotesNull() {
        ArrayList<String> nullInNumVotes = new ArrayList<>();
        nullInNumVotes.add("tt0000002");
        nullInNumVotes.add("6.1");
        nullInNumVotes.add("\\N");

        String correctOutput = "{\"tconst\":\"tt0000002\",\"averageRating\":6.1,\"numVotes\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInNumVotes).toString());
    }
}
