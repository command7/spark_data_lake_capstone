package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitleBasics extends DataUnit{

    public TitleBasics() {
        super("title_basics.csv");
    }


    @Override
    public JSONObject convertToJson(String[] rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "tconst", rowData[0], "string");
        this.insertIntoJsonObject(dataInJson, "titleType", rowData[1], "string");
        this.insertIntoJsonObject(dataInJson, "primaryTitle", rowData[2], "string");
        this.insertIntoJsonObject(dataInJson, "originalTitle", rowData[3], "string");
        this.insertIntoJsonObject(dataInJson, "isAdult", rowData[4], "integer");
        this.insertIntoJsonObject(dataInJson, "startYear", rowData[5], "integer");
        this.insertIntoJsonObject(dataInJson, "endYear", rowData[6], "integer");
        this.insertIntoJsonObject(dataInJson, "runTimeMinutes", rowData[7], "integer");
        this.insertIntoJsonObject(dataInJson, "genre", rowData[8], "string");

        return dataInJson;
    }
}
