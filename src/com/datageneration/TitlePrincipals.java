package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitlePrincipals extends DataUnit{

    public TitlePrincipals() {
        super("title_principals.csv",
                true);
    }

    @Override
    public JSONObject convertToJson(String[] rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "tconst", rowData[0], "string");
        this.insertIntoJsonObject(dataInJson, "ordering", rowData[1], "integer");
        this.insertIntoJsonObject(dataInJson, "nconst", rowData[2], "string");
        this.insertIntoJsonObject(dataInJson, "category", rowData[3], "string");
        this.insertIntoJsonObject(dataInJson, "job", rowData[4], "string");
        this.insertIntoJsonObject(dataInJson, "characters", rowData[5], "string");

        return dataInJson;
    }
}
