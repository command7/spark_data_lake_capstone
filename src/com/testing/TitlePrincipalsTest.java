package com.testing;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import com.datageneration.TitlePrincipals;


public class TitlePrincipalsTest {
    TitlePrincipals testInstance;

    @Before
    public void initializeTesting() {
        testInstance = new TitlePrincipals();
    }

    @Test
    public void checkGetNumberOfRecords() {
        Assert.assertEquals(testInstance.getNumberOfRecords(), 1597829);
    }

    @Test
    public void convertToJsonTconstNull() {
        String[] nullInTconst = new String[6];
        nullInTconst[0] = ("\\N");
        nullInTconst[1] = ("1");
        nullInTconst[2] = ("nm1588970");
        nullInTconst[3] = ("self");
        nullInTconst[4] = ("director");
        nullInTconst[5] = ("[Herself]");

        String correctOutput = "{\"characters\":\"[Herself]\",\"tconst\":null,\"ordering\":1,\"nconst\":\"" +
                "nm1588970\",\"category\":\"self\",\"job\":\"director\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTconst).toString());
    }

    @Test
    public void convertToJsonOrderingNull() {
        String[] nullInOrdering = new String[6];
        nullInOrdering[0] = ("tt0000001");
        nullInOrdering[1] = ("\\N");
        nullInOrdering[2] = ("nm1588970");
        nullInOrdering[3] = ("self");
        nullInOrdering[4] = ("director");
        nullInOrdering[5] = ("[Herself]");

        String correctOutput = "{\"characters\":\"[Herself]\",\"tconst\":\"tt0000001\",\"ordering\":null,\"nconst\":\"" +
                "nm1588970\",\"category\":\"self\",\"job\":\"director\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInOrdering).toString());
    }

    @Test
    public void convertToJsonNconstNull() {
        String[] nullInNconst = new String[6];
        nullInNconst[0] = ("tt0000001");
        nullInNconst[1] = ("1");
        nullInNconst[2] = ("\\N");
        nullInNconst[3] = ("self");
        nullInNconst[4] = ("director");
        nullInNconst[5] = ("[Herself]");

        String correctOutput = "{\"characters\":\"[Herself]\",\"tconst\":\"tt0000001\",\"ordering\":1,\"nconst\":" +
                "null,\"category\":\"self\",\"job\":\"director\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInNconst).toString());
    }

    @Test
    public void convertToJsonCategoryNull() {
        String[] nullInCategory = new String[6];
        nullInCategory[0] = ("tt0000001");
        nullInCategory[1] = ("1");
        nullInCategory[2] = ("nm1588970");
        nullInCategory[3] = ("\\N");
        nullInCategory[4] = ("director");
        nullInCategory[5] = ("[Herself]");

        String correctOutput = "{\"characters\":\"[Herself]\",\"tconst\":\"tt0000001\",\"ordering\":1,\"nconst\":\"" +
                "nm1588970\",\"category\":null,\"job\":\"director\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInCategory).toString());
    }

    @Test
    public void convertToJsonJobNull() {
        String[] nullInJob = new String[6];
        nullInJob[0] = ("tt0000001");
        nullInJob[1] = ("1");
        nullInJob[2] = ("nm1588970");
        nullInJob[3] = ("self");
        nullInJob[4] = ("\\N");
        nullInJob[5] = ("[Herself]");

        String correctOutput = "{\"characters\":\"[Herself]\",\"tconst\":\"tt0000001\",\"ordering\":1,\"nconst\":\"" +
                "nm1588970\",\"category\":\"self\",\"job\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInJob).toString());
    }

    @Test
    public void convertToJsonCharactersNull() {
        String[] nullInCharacters = new String[6];
        nullInCharacters[0] = ("tt0000001");
        nullInCharacters[1] = ("1");
        nullInCharacters[2] = ("nm1588970");
        nullInCharacters[3] = ("self");
        nullInCharacters[4] = ("director");
        nullInCharacters[5] = ("\\N");

        String correctOutput = "{\"characters\":null,\"tconst\":\"tt0000001\",\"ordering\":1,\"nconst\":\"" +
                "nm1588970\",\"category\":\"self\",\"job\":\"director\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInCharacters).toString());
    }
}
