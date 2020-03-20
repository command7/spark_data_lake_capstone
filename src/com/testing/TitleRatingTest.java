package com.testing;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import com.datageneration.TitleRating;

import java.util.ArrayList;

public class TitleRatingTest {
    TitleRating testInstance;
    ArrayList<String> nullInTconst = new ArrayList<>();
    ArrayList<String> nullInAverageRating = new ArrayList<>();
    ArrayList<String> nullInNumVotes = new ArrayList<>();

    public void fillUpNullInTconst() {
        nullInTconst.add("\\N");
        nullInTconst.add("6.1");
        nullInTconst.add("186.0");
    }

    public void fillUpNullInAverageRating() {
        nullInAverageRating.add("tt0000002");
        nullInAverageRating.add("\\N");
        nullInAverageRating.add("186.0");
    }

    public void fillUpNullInNumVotes() {
        nullInNumVotes.add("tt0000002");
        nullInNumVotes.add("6.1");
        nullInNumVotes.add("\\N");
    }

    @Before
    public void initializeTesting() {
        testInstance = new TitleRating();
        fillUpNullInTconst();
        fillUpNullInAverageRating();
        fillUpNullInNumVotes();
    }

    @Test
    public void convertToJsonTconstNull() {
        String correctOutput = "{\"tconst\":null,\"averageRating\":6.1,\"numVotes\":186}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTconst).toString());
    }

    @Test
    public void convertToJsonTAverageRatingNull() {
        String correctOutput = "{\"tconst\":\"tt0000002\",\"averageRating\":null,\"numVotes\":186}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInAverageRating).toString());
    }

    @Test
    public void convertToJsonNumVotesNull() {
        String correctOutput = "{\"tconst\":\"tt0000002\",\"averageRating\":6.1,\"numVotes\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInNumVotes).toString());
    }
}
