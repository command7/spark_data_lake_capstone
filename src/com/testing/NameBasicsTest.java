package com.testing;

import com.datageneration.NameBasics;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class NameBasicsTest {
    NameBasics testInstance;

    @Before
    public void initializeTesting() {
        testInstance = new NameBasics();
    }

    @Test
    public void convertToJsonNconstNull() {
        ArrayList<String> nullInNconst = new ArrayList<>();
        nullInNconst.add("\\N");
        nullInNconst.add("Georges Méliès");
        nullInNconst.add("1861");
        nullInNconst.add("1938");
        nullInNconst.add("director,actor,producer");
        nullInNconst.add("tt0000091,tt0000499,tt0002113,tt0223267");

        String correctOutput = "{\"birthYear\":1861,\"deathYear\":1938,\"primaryProfession\":" +
                "\"director,actor,producer\",\"nconst\":null," +
                "\"knownForTitles\":\"tt0000091,tt0000499,tt0002113,tt0223267\",\"primaryName\":\"Georges Méliès\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInNconst).toString());
    }

    @Test
    public void convertToJsonPrimaryNameNull() {
        ArrayList<String> nullInPrimaryName = new ArrayList<>();
        nullInPrimaryName.add("nm0617588");
        nullInPrimaryName.add("\\N");
        nullInPrimaryName.add("1861");
        nullInPrimaryName.add("1938");
        nullInPrimaryName.add("director,actor,producer");
        nullInPrimaryName.add("tt0000091,tt0000499,tt0002113,tt0223267");

        String correctOutput = "{\"birthYear\":1861,\"deathYear\":1938,\"primaryProfession\":" +
                "\"director,actor,producer\",\"nconst\":\"nm0617588\"," +
                "\"knownForTitles\":\"tt0000091,tt0000499,tt0002113,tt0223267\",\"primaryName\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInPrimaryName).toString());
    }

    @Test
    public void convertToJsonBirthYearNull() {
        ArrayList<String> nullInBirthYear = new ArrayList<>();
        nullInBirthYear.add("nm0617588");
        nullInBirthYear.add("Georges Méliès");
        nullInBirthYear.add("\\N");
        nullInBirthYear.add("1938");
        nullInBirthYear.add("director,actor,producer");
        nullInBirthYear.add("tt0000091,tt0000499,tt0002113,tt0223267");

        String correctOutput = "{\"birthYear\":null,\"deathYear\":1938,\"primaryProfession\":" +
                "\"director,actor,producer\",\"nconst\":\"nm0617588\"," +
                "\"knownForTitles\":\"tt0000091,tt0000499,tt0002113,tt0223267\",\"primaryName\":\"Georges Méliès\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInBirthYear).toString());
    }

    @Test
    public void convertToJsonDeathYearNull() {
        ArrayList<String> nullInDeathYear = new ArrayList<>();
        nullInDeathYear.add("nm0617588");
        nullInDeathYear.add("Georges Méliès");
        nullInDeathYear.add("1861");
        nullInDeathYear.add("\\N");
        nullInDeathYear.add("director,actor,producer");
        nullInDeathYear.add("tt0000091,tt0000499,tt0002113,tt0223267");

        String correctOutput = "{\"birthYear\":1861,\"deathYear\":null,\"primaryProfession\":" +
                "\"director,actor,producer\",\"nconst\":\"nm0617588\"," +
                "\"knownForTitles\":\"tt0000091,tt0000499,tt0002113,tt0223267\",\"primaryName\":\"Georges Méliès\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInDeathYear).toString());
    }

    @Test
    public void convertToJsonPrimaryProfessionNull() {
        ArrayList<String> nullInPrimaryProfession = new ArrayList<>();
        nullInPrimaryProfession.add("nm0617588");
        nullInPrimaryProfession.add("Georges Méliès");
        nullInPrimaryProfession.add("1861");
        nullInPrimaryProfession.add("1938");
        nullInPrimaryProfession.add("\\N");
        nullInPrimaryProfession.add("tt0000091,tt0000499,tt0002113,tt0223267");

        String correctOutput = "{\"birthYear\":1861,\"deathYear\":1938,\"primaryProfession\":" +
                "null,\"nconst\":\"nm0617588\"," +
                "\"knownForTitles\":\"tt0000091,tt0000499,tt0002113,tt0223267\",\"primaryName\":\"Georges Méliès\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInPrimaryProfession).toString());
    }

    @Test
    public void convertToJsonKnownForTitlesNull() {
        ArrayList<String> nullInKnownForTitles = new ArrayList<>();
        nullInKnownForTitles.add("nm0617588");
        nullInKnownForTitles.add("Georges Méliès");
        nullInKnownForTitles.add("1861");
        nullInKnownForTitles.add("1938");
        nullInKnownForTitles.add("director,actor,producer");
        nullInKnownForTitles.add("\\N");

        String correctOutput = "{\"birthYear\":1861,\"deathYear\":1938,\"primaryProfession\":" +
                "\"director,actor,producer\",\"nconst\":\"nm0617588\"," +
                "\"knownForTitles\":null,\"primaryName\":\"Georges Méliès\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInKnownForTitles).toString());
    }
}
