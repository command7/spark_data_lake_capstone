package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitlePrincipals extends DataUnit{

    public TitlePrincipals() {
        this.setPreProcessUniqueIdFlag(true);
        this.setFileName("title_principals.csv");
        this.initializeFileData();
        this.readDataContentsToMemory();
    }

    @Override
    public JSONObject convertToJson(ArrayList<String> rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "tconst", rowData.get(0), "string");
        this.insertIntoJsonObject(dataInJson, "ordering", rowData.get(1), "integer");
        this.insertIntoJsonObject(dataInJson, "nconst", rowData.get(2), "string");
        this.insertIntoJsonObject(dataInJson, "category", rowData.get(3), "string");
        this.insertIntoJsonObject(dataInJson, "job", rowData.get(4), "string");
        this.insertIntoJsonObject(dataInJson, "characters", rowData.get(5), "string");

        return dataInJson;
    }
}
