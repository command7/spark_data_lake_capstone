package com.testing;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import com.datageneration.TitleBasics;

import java.util.ArrayList;

public class TitleBasicsTest {
    TitleBasics testInstance;

    @Before
    public void initializeTesting() {
        testInstance = new TitleBasics();
    }

    @Test
    public void convertToJsonTconstNull() {
        ArrayList<String> nullInTconst = new ArrayList<>();
        nullInTconst.add("\\N");
        nullInTconst.add("short");
        nullInTconst.add("Carmencita");
        nullInTconst.add("Carmencita");
        nullInTconst.add("0");
        nullInTconst.add("1894");
        nullInTconst.add("1990");
        nullInTconst.add("1");
        nullInTconst.add("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":null,\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTconst).toString());
    }

    @Test
    public void convertToJsonTitleTypeNull() {
        ArrayList<String> nullInTitleType = new ArrayList<>();
        nullInTitleType.add("tt0000001");
        nullInTitleType.add("\\N");
        nullInTitleType.add("Carmencita");
        nullInTitleType.add("Carmencita");
        nullInTitleType.add("0");
        nullInTitleType.add("1894");
        nullInTitleType.add("1990");
        nullInTitleType.add("1");
        nullInTitleType.add("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":null,\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTitleType).toString());
    }

    @Test
    public void convertToJsonPrimaryTitleNull() {
        ArrayList<String> nullInPrimaryTitle = new ArrayList<>();
        nullInPrimaryTitle.add("tt0000001");
        nullInPrimaryTitle.add("short");
        nullInPrimaryTitle.add("\\N");
        nullInPrimaryTitle.add("Carmencita");
        nullInPrimaryTitle.add("0");
        nullInPrimaryTitle.add("1894");
        nullInPrimaryTitle.add("1990");
        nullInPrimaryTitle.add("1");
        nullInPrimaryTitle.add("Documentary");

        String correctOutput = "{\"primaryTitle\":null,\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInPrimaryTitle).toString());
    }

    @Test
    public void convertToJsonOriginalTitleNull() {
        ArrayList<String> nullInOriginalTitle = new ArrayList<>();
        nullInOriginalTitle.add("tt0000001");
        nullInOriginalTitle.add("short");
        nullInOriginalTitle.add("Carmencita");
        nullInOriginalTitle.add("\\N");
        nullInOriginalTitle.add("0");
        nullInOriginalTitle.add("1894");
        nullInOriginalTitle.add("1990");
        nullInOriginalTitle.add("1");
        nullInOriginalTitle.add("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":null,\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInOriginalTitle).toString());
    }

    @Test
    public void convertToJsonIsAdultNull() {
        ArrayList<String> nullInIsAdult = new ArrayList<>();
        nullInIsAdult.add("tt0000001");
        nullInIsAdult.add("short");
        nullInIsAdult.add("Carmencita");
        nullInIsAdult.add("Carmencita");
        nullInIsAdult.add("\\N");
        nullInIsAdult.add("1894");
        nullInIsAdult.add("1990");
        nullInIsAdult.add("1");
        nullInIsAdult.add("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInIsAdult).toString());
    }

    @Test
    public void convertToJsonStartYearNull() {
        ArrayList<String> nullInStartYear = new ArrayList<>();
        nullInStartYear.add("tt0000001");
        nullInStartYear.add("short");
        nullInStartYear.add("Carmencita");
        nullInStartYear.add("Carmencita");
        nullInStartYear.add("0");
        nullInStartYear.add("\\N");
        nullInStartYear.add("1990");
        nullInStartYear.add("1");
        nullInStartYear.add("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":null,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInStartYear).toString());
    }

    @Test
    public void convertToJsonEndYearNull() {
        ArrayList<String> nullInEndYear = new ArrayList<>();
        nullInEndYear.add("tt0000001");
        nullInEndYear.add("short");
        nullInEndYear.add("Carmencita");
        nullInEndYear.add("Carmencita");
        nullInEndYear.add("0");
        nullInEndYear.add("1894");
        nullInEndYear.add("\\N");
        nullInEndYear.add("1");
        nullInEndYear.add("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":null,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInEndYear).toString());
    }

    @Test
    public void convertToJsonRunTimeMinutesNull() {
        ArrayList<String> nullInRunTimeMinutes = new ArrayList<>();
        nullInRunTimeMinutes.add("tt0000001");
        nullInRunTimeMinutes.add("short");
        nullInRunTimeMinutes.add("Carmencita");
        nullInRunTimeMinutes.add("Carmencita");
        nullInRunTimeMinutes.add("0");
        nullInRunTimeMinutes.add("1894");
        nullInRunTimeMinutes.add("1990");
        nullInRunTimeMinutes.add("\\N");
        nullInRunTimeMinutes.add("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":null,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInRunTimeMinutes).toString());
    }

    @Test
    public void convertToJsonGenreNull() {
        ArrayList<String> nullInGenre = new ArrayList<>();
        nullInGenre.add("tt0000001");
        nullInGenre.add("short");
        nullInGenre.add("Carmencita");
        nullInGenre.add("Carmencita");
        nullInGenre.add("0");
        nullInGenre.add("1894");
        nullInGenre.add("1990");
        nullInGenre.add("1");
        nullInGenre.add("\\N");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":null,\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInGenre).toString());
    }

    @Test
    public void checkGetNumberOfRecords() {
        Assert.assertEquals(testInstance.getNumberOfRecords(), 976509);
    }
}
