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
        Assert.assertEquals(testInstance.getNumberOfRecords(), 976509);
    }

    @Test
    public void convertToJsonTconstNull() {
        String[] nullInTconst = new String[9];
        nullInTconst[0] = ("\\N");
        nullInTconst[1] = ("short");
        nullInTconst[2] = ("Carmencita");
        nullInTconst[3] = ("Carmencita");
        nullInTconst[4] = ("0");
        nullInTconst[5] = ("1894");
        nullInTconst[6] = ("1990");
        nullInTconst[7] = ("1");
        nullInTconst[8] = ("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":null,\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTconst).toString());
    }

    @Test
    public void convertToJsonTitleTypeNull() {
        String[] nullInTitleType = new String[9];
        nullInTitleType[0] = ("tt0000001");
        nullInTitleType[1] = ("\\N");
        nullInTitleType[2] = ("Carmencita");
        nullInTitleType[3] = ("Carmencita");
        nullInTitleType[4] = ("0");
        nullInTitleType[5] = ("1894");
        nullInTitleType[6] = ("1990");
        nullInTitleType[7] = ("1");
        nullInTitleType[8] = ("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":null,\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTitleType).toString());
    }

    @Test
    public void convertToJsonPrimaryTitleNull() {
        String[] nullInPrimaryTitle = new String[9];
        nullInPrimaryTitle[0] = ("tt0000001");
        nullInPrimaryTitle[1] = ("short");
        nullInPrimaryTitle[2] = ("\\N");
        nullInPrimaryTitle[3] = ("Carmencita");
        nullInPrimaryTitle[4] = ("0");
        nullInPrimaryTitle[5] = ("1894");
        nullInPrimaryTitle[6] = ("1990");
        nullInPrimaryTitle[7] = ("1");
        nullInPrimaryTitle[8] = ("Documentary");

        String correctOutput = "{\"primaryTitle\":null,\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInPrimaryTitle).toString());
    }

    @Test
    public void convertToJsonOriginalTitleNull() {
        String[] nullInOriginalTitle = new String[9];
        nullInOriginalTitle[0] = ("tt0000001");
        nullInOriginalTitle[1] = ("short");
        nullInOriginalTitle[2] = ("Carmencita");
        nullInOriginalTitle[3] = ("\\N");
        nullInOriginalTitle[4] = ("0");
        nullInOriginalTitle[5] = ("1894");
        nullInOriginalTitle[6] = ("1990");
        nullInOriginalTitle[7] = ("1");
        nullInOriginalTitle[8] = ("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":null,\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInOriginalTitle).toString());
    }

    @Test
    public void convertToJsonIsAdultNull() {
        String[] nullInIsAdult = new String[9];
        nullInIsAdult[0] = ("tt0000001");
        nullInIsAdult[1] = ("short");
        nullInIsAdult[2] = ("Carmencita");
        nullInIsAdult[3] = ("Carmencita");
        nullInIsAdult[4] = ("\\N");
        nullInIsAdult[5] = ("1894");
        nullInIsAdult[6] = ("1990");
        nullInIsAdult[7] = ("1");
        nullInIsAdult[8] = ("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInIsAdult).toString());
    }

    @Test
    public void convertToJsonStartYearNull() {
        String[] nullInStartYear = new String[9];
        nullInStartYear[0] = ("tt0000001");
        nullInStartYear[1] = ("short");
        nullInStartYear[2] = ("Carmencita");
        nullInStartYear[3] = ("Carmencita");
        nullInStartYear[4] = ("0");
        nullInStartYear[5] = ("\\N");
        nullInStartYear[6] = ("1990");
        nullInStartYear[7] = ("1");
        nullInStartYear[8] = ("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":null,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInStartYear).toString());
    }

    @Test
    public void convertToJsonEndYearNull() {
        String[] nullInEndYear = new String[9];
        nullInEndYear[0] = ("tt0000001");
        nullInEndYear[1] = ("short");
        nullInEndYear[2] = ("Carmencita");
        nullInEndYear[3] = ("Carmencita");
        nullInEndYear[4] = ("0");
        nullInEndYear[5] = ("1894");
        nullInEndYear[6] = ("\\N");
        nullInEndYear[7] = ("1");
        nullInEndYear[8] = ("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":null,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInEndYear).toString());
    }

    @Test
    public void convertToJsonRunTimeMinutesNull() {
        String[] nullInRunTimeMinutes = new String[9];
        nullInRunTimeMinutes[0] = ("tt0000001");
        nullInRunTimeMinutes[1] = ("short");
        nullInRunTimeMinutes[2] = ("Carmencita");
        nullInRunTimeMinutes[3] = ("Carmencita");
        nullInRunTimeMinutes[4] = ("0");
        nullInRunTimeMinutes[5] = ("1894");
        nullInRunTimeMinutes[6] = ("1990");
        nullInRunTimeMinutes[7] = ("\\N");
        nullInRunTimeMinutes[8] = ("Documentary");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":null,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInRunTimeMinutes).toString());
    }

    @Test
    public void convertToJsonGenreNull() {
        String[] nullInGenre = new String[9];
        nullInGenre[0] = ("tt0000001");
        nullInGenre[1] = ("short");
        nullInGenre[2] = ("Carmencita");
        nullInGenre[3] = ("Carmencita");
        nullInGenre[4] = ("0");
        nullInGenre[5] = ("1894");
        nullInGenre[6] = ("1990");
        nullInGenre[7] = ("1");
        nullInGenre[8] = ("\\N");

        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":null,\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInGenre).toString());
    }
}
