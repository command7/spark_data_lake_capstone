package com.testing;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import com.datageneration.TitleBasics;

import java.util.ArrayList;

public class TitleBasicsTest {
    TitleBasics testInstance;
    ArrayList<String> nullInPrimaryTitle = new ArrayList<>();
    ArrayList<String> nullInTitleType = new ArrayList<>();
    ArrayList<String> nullInTconst = new ArrayList<>();
    ArrayList<String> nullInOriginalTitle = new ArrayList<>();
    ArrayList<String> nullInRunTimeMinutes = new ArrayList<>();
    ArrayList<String> nullInStartYear = new ArrayList<>();
    ArrayList<String> nullInGenre = new ArrayList<>();
    ArrayList<String> nullInEndYear = new ArrayList<>();
    ArrayList<String> nullInIsAdult = new ArrayList<>();

    public void fillUpNullInPrimaryTitle() {
        nullInPrimaryTitle.add("tt0000001");
        nullInPrimaryTitle.add("short");
        nullInPrimaryTitle.add("\\N");
        nullInPrimaryTitle.add("Carmencita");
        nullInPrimaryTitle.add("0");
        nullInPrimaryTitle.add("1894");
        nullInPrimaryTitle.add("1990");
        nullInPrimaryTitle.add("1");
        nullInPrimaryTitle.add("Documentary");
    }

    public void fillUpNullInTitleType() {
        nullInTitleType.add("tt0000001");
        nullInTitleType.add("\\N");
        nullInTitleType.add("Carmencita");
        nullInTitleType.add("Carmencita");
        nullInTitleType.add("0");
        nullInTitleType.add("1894");
        nullInTitleType.add("1990");
        nullInTitleType.add("1");
        nullInTitleType.add("Documentary");
    }

    public void fillUpNullInTconst() {
        nullInTconst.add("\\N");
        nullInTconst.add("short");
        nullInTconst.add("Carmencita");
        nullInTconst.add("Carmencita");
        nullInTconst.add("0");
        nullInTconst.add("1894");
        nullInTconst.add("1990");
        nullInTconst.add("1");
        nullInTconst.add("Documentary");
    }

    public void fillUpNullInRunTimeMinutes() {
        nullInRunTimeMinutes.add("tt0000001");
        nullInRunTimeMinutes.add("short");
        nullInRunTimeMinutes.add("Carmencita");
        nullInRunTimeMinutes.add("Carmencita");
        nullInRunTimeMinutes.add("0");
        nullInRunTimeMinutes.add("1894");
        nullInRunTimeMinutes.add("1990");
        nullInRunTimeMinutes.add("\\N");
        nullInRunTimeMinutes.add("Documentary");
    }

    public void fillUpNullInStartYear() {
        nullInStartYear.add("tt0000001");
        nullInStartYear.add("short");
        nullInStartYear.add("Carmencita");
        nullInStartYear.add("Carmencita");
        nullInStartYear.add("0");
        nullInStartYear.add("\\N");
        nullInStartYear.add("1990");
        nullInStartYear.add("1");
        nullInStartYear.add("Documentary");
    }

    public void fillUpNullInGenre() {
        nullInGenre.add("tt0000001");
        nullInGenre.add("short");
        nullInGenre.add("Carmencita");
        nullInGenre.add("Carmencita");
        nullInGenre.add("0");
        nullInGenre.add("1894");
        nullInGenre.add("1990");
        nullInGenre.add("1");
        nullInGenre.add("\\N");
    }

    public void fillUpNullInEndYear() {
        nullInEndYear.add("tt0000001");
        nullInEndYear.add("short");
        nullInEndYear.add("Carmencita");
        nullInEndYear.add("Carmencita");
        nullInEndYear.add("0");
        nullInEndYear.add("1894");
        nullInEndYear.add("\\N");
        nullInEndYear.add("1");
        nullInEndYear.add("Documentary");
    }

    public void fillUpNullInOriginalTitle() {
        nullInOriginalTitle.add("tt0000001");
        nullInOriginalTitle.add("short");
        nullInOriginalTitle.add("Carmencita");
        nullInOriginalTitle.add("\\N");
        nullInOriginalTitle.add("0");
        nullInOriginalTitle.add("1894");
        nullInOriginalTitle.add("1990");
        nullInOriginalTitle.add("1");
        nullInOriginalTitle.add("Documentary");
    }

    public void fillUpNullInIsAdult() {
        nullInIsAdult.add("tt0000001");
        nullInIsAdult.add("short");
        nullInIsAdult.add("Carmencita");
        nullInIsAdult.add("Carmencita");
        nullInIsAdult.add("\\N");
        nullInIsAdult.add("1894");
        nullInIsAdult.add("1990");
        nullInIsAdult.add("1");
        nullInIsAdult.add("Documentary");
    }

    @Before
    public void initializeTesting() {
        testInstance = new TitleBasics();
        fillUpNullInTconst();
        fillUpNullInTitleType();
        fillUpNullInPrimaryTitle();
        fillUpNullInOriginalTitle();
        fillUpNullInIsAdult();
        fillUpNullInStartYear();
        fillUpNullInEndYear();
        fillUpNullInRunTimeMinutes();
        fillUpNullInGenre();
    }
    @Test
    public void convertToJsonTconstNull() {
        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":null,\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTconst).toString());
    }

    @Test
    public void convertToJsonTitleTypeNull() {
        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":null,\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTitleType).toString());
    }

    @Test
    public void convertToJsonPrimaryTitleNull() {
        String correctOutput = "{\"primaryTitle\":null,\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInPrimaryTitle).toString());
    }

    @Test
    public void convertToJsonOriginalTitleNull() {
        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":null,\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInOriginalTitle).toString());
    }

    @Test
    public void convertToJsonIsAdultNull() {
        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInIsAdult).toString());
    }

    @Test
    public void convertToJsonStartYearNull() {
        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":null,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInStartYear).toString());
    }

    @Test
    public void convertToJsonEndYearNull() {
        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":null,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInEndYear).toString());
    }

    @Test
    public void convertToJsonRunTimeMinutesNull() {
        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":null,\"startYear\":1894,\"genre\":\"Documentary\",\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInRunTimeMinutes).toString());
    }

    @Test
    public void convertToJsonGenreNull() {
        String correctOutput = "{\"primaryTitle\":\"Carmencita\",\"titleType\":\"short\",\"tconst\":\"tt0000001\",\"" +
                "originalTitle\":\"Carmencita\",\"runTimeMinutes\":1,\"startYear\":1894,\"genre\":null,\"" +
                "endYear\":1990,\"isAdult\":0}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInGenre).toString());
    }
}
