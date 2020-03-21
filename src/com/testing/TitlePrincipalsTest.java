package com.testing;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import com.datageneration.TitlePrincipals;

import java.util.ArrayList;

public class TitlePrincipalsTest {
    TitlePrincipals testInstance;

    @Before
    public void initializeTesting() {
        testInstance = new TitlePrincipals();
    }

    @Test
    public void convertToJsonTconstNull() {
        ArrayList<String> nullInTconst = new ArrayList<>();
        nullInTconst.add("\\N");
        nullInTconst.add("1");
        nullInTconst.add("nm1588970");
        nullInTconst.add("self");
        nullInTconst.add("director");
        nullInTconst.add("[Herself]");

        String correctOutput = "{\"characters\":\"[Herself]\",\"tconst\":null,\"ordering\":1,\"nconst\":\"" +
                "nm1588970\",\"category\":\"self\",\"job\":\"director\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInTconst).toString());
    }

    @Test
    public void convertToJsonOrderingNull() {
        ArrayList<String> nullInOrdering = new ArrayList<>();
        nullInOrdering.add("tt0000001");
        nullInOrdering.add("\\N");
        nullInOrdering.add("nm1588970");
        nullInOrdering.add("self");
        nullInOrdering.add("director");
        nullInOrdering.add("[Herself]");

        String correctOutput = "{\"characters\":\"[Herself]\",\"tconst\":\"tt0000001\",\"ordering\":null,\"nconst\":\"" +
                "nm1588970\",\"category\":\"self\",\"job\":\"director\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInOrdering).toString());
    }

    @Test
    public void convertToJsonNconstNull() {
        ArrayList<String> nullInNconst = new ArrayList<>();
        nullInNconst.add("tt0000001");
        nullInNconst.add("1");
        nullInNconst.add("\\N");
        nullInNconst.add("self");
        nullInNconst.add("director");
        nullInNconst.add("[Herself]");

        String correctOutput = "{\"characters\":\"[Herself]\",\"tconst\":\"tt0000001\",\"ordering\":1,\"nconst\":" +
                "null,\"category\":\"self\",\"job\":\"director\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInNconst).toString());
    }

    @Test
    public void convertToJsonCategoryNull() {
        ArrayList<String> nullInCategory = new ArrayList<>();
        nullInCategory.add("tt0000001");
        nullInCategory.add("1");
        nullInCategory.add("nm1588970");
        nullInCategory.add("\\N");
        nullInCategory.add("director");
        nullInCategory.add("[Herself]");

        String correctOutput = "{\"characters\":\"[Herself]\",\"tconst\":\"tt0000001\",\"ordering\":1,\"nconst\":\"" +
                "nm1588970\",\"category\":null,\"job\":\"director\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInCategory).toString());
    }

    @Test
    public void convertToJsonJobNull() {
        ArrayList<String> nullInJob = new ArrayList<>();
        nullInJob.add("tt0000001");
        nullInJob.add("1");
        nullInJob.add("nm1588970");
        nullInJob.add("self");
        nullInJob.add("\\N");
        nullInJob.add("[Herself]");

        String correctOutput = "{\"characters\":\"[Herself]\",\"tconst\":\"tt0000001\",\"ordering\":1,\"nconst\":\"" +
                "nm1588970\",\"category\":\"self\",\"job\":null}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInJob).toString());
    }

    @Test
    public void convertToJsonCharactersNull() {
        ArrayList<String> nullInCharacters = new ArrayList<>();
        nullInCharacters.add("tt0000001");
        nullInCharacters.add("1");
        nullInCharacters.add("nm1588970");
        nullInCharacters.add("self");
        nullInCharacters.add("director");
        nullInCharacters.add("\\N");

        String correctOutput = "{\"characters\":null,\"tconst\":\"tt0000001\",\"ordering\":1,\"nconst\":\"" +
                "nm1588970\",\"category\":\"self\",\"job\":\"director\"}";
        Assert.assertEquals(correctOutput, testInstance.convertToJson(nullInCharacters).toString());
    }
}
