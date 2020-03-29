package com.testing;

import com.datageneration.NameBasic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class NameBasicsTest {
    NameBasic testInstance;

    @Before
    public void initializeTesting() {
        testInstance = new NameBasic();
    }

    @Test
    public void checkGetNumberOfRecords() {
        Assert.assertEquals(testInstance.getNumberOfRecords(), 1494835);
    }

    @Test
    public void convertToJsonNconstNull() {
        String[] nullInNconst = new String[6];
        nullInNconst[0] = ("\\N");
        nullInNconst[1] = ("Georges Méliès");
        nullInNconst[2] = ("1861");
        nullInNconst[3] = ("1938");
        nullInNconst[4] = ("director,actor,producer");
        nullInNconst[5] = ("tt0000091,tt0000499,tt0002113,tt0223267");

        String correctOutput = "{\"birthYear\":1861,\"deathYear\":1938,\"primaryProfession\":" +
                "\"director,actor,producer\",\"nconst\":null," +
                "\"knownForTitles\":\"tt0000091,tt0000499,tt0002113,tt0223267\",\"primaryName\":\"Georges Méliès\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInNconst).toString());
    }

    @Test
    public void convertToJsonPrimaryNameNull() {
        String[] nullInPrimaryName = new String[6];
        nullInPrimaryName[0] = ("nm0617588");
        nullInPrimaryName[1] = ("\\N");
        nullInPrimaryName[2] = ("1861");
        nullInPrimaryName[3] = ("1938");
        nullInPrimaryName[4] = ("director,actor,producer");
        nullInPrimaryName[5] = ("tt0000091,tt0000499,tt0002113,tt0223267");

        String correctOutput = "{\"birthYear\":1861,\"deathYear\":1938,\"primaryProfession\":" +
                "\"director,actor,producer\",\"nconst\":\"nm0617588\"," +
                "\"knownForTitles\":\"tt0000091,tt0000499,tt0002113,tt0223267\",\"primaryName\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInPrimaryName).toString());
    }

    @Test
    public void convertToJsonBirthYearNull() {
        String[] nullInBirthYear = new String[6];
        nullInBirthYear[0] = ("nm0617588");
        nullInBirthYear[1] = ("Georges Méliès");
        nullInBirthYear[2] = ("\\N");
        nullInBirthYear[3] = ("1938");
        nullInBirthYear[4] = ("director,actor,producer");
        nullInBirthYear[5] = ("tt0000091,tt0000499,tt0002113,tt0223267");

        String correctOutput = "{\"birthYear\":null,\"deathYear\":1938,\"primaryProfession\":" +
                "\"director,actor,producer\",\"nconst\":\"nm0617588\"," +
                "\"knownForTitles\":\"tt0000091,tt0000499,tt0002113,tt0223267\",\"primaryName\":\"Georges Méliès\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInBirthYear).toString());
    }

    @Test
    public void convertToJsonDeathYearNull() {
        String[] nullInDeathYear = new String[6];
        nullInDeathYear[0] = ("nm0617588");
        nullInDeathYear[1] = ("Georges Méliès");
        nullInDeathYear[2] = ("1861");
        nullInDeathYear[3] = ("\\N");
        nullInDeathYear[4] = ("director,actor,producer");
        nullInDeathYear[5] = ("tt0000091,tt0000499,tt0002113,tt0223267");

        String correctOutput = "{\"birthYear\":1861,\"deathYear\":null,\"primaryProfession\":" +
                "\"director,actor,producer\",\"nconst\":\"nm0617588\"," +
                "\"knownForTitles\":\"tt0000091,tt0000499,tt0002113,tt0223267\",\"primaryName\":\"Georges Méliès\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInDeathYear).toString());
    }

    @Test
    public void convertToJsonPrimaryProfessionNull() {
        String[] nullInPrimaryProfession = new String[6];
        nullInPrimaryProfession[0] = ("nm0617588");
        nullInPrimaryProfession[1] = ("Georges Méliès");
        nullInPrimaryProfession[2] = ("1861");
        nullInPrimaryProfession[3] = ("1938");
        nullInPrimaryProfession[4] = ("\\N");
        nullInPrimaryProfession[5] = ("tt0000091,tt0000499,tt0002113,tt0223267");

        String correctOutput = "{\"birthYear\":1861,\"deathYear\":1938,\"primaryProfession\":" +
                "null,\"nconst\":\"nm0617588\"," +
                "\"knownForTitles\":\"tt0000091,tt0000499,tt0002113,tt0223267\",\"primaryName\":\"Georges Méliès\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInPrimaryProfession).toString());
    }

    @Test
    public void convertToJsonKnownForTitlesNull() {
        String[] nullInKnownForTitles = new String[6];
        nullInKnownForTitles[0] = ("nm0617588");
        nullInKnownForTitles[1] = ("Georges Méliès");
        nullInKnownForTitles[2] = ("1861");
        nullInKnownForTitles[3] = ("1938");
        nullInKnownForTitles[4] = ("director,actor,producer");
        nullInKnownForTitles[5] = ("\\N");

        String correctOutput = "{\"birthYear\":1861,\"deathYear\":1938,\"primaryProfession\":" +
                "\"director,actor,producer\",\"nconst\":\"nm0617588\"," +
                "\"knownForTitles\":null,\"primaryName\":\"Georges Méliès\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInKnownForTitles).toString());
    }
}
