package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitleBasics extends DataUnit{

    public TitleBasics() {
        super("title_basics.csv");
    }


    @Override
    public JSONObject convertToJson(ArrayList<String> rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "tconst", rowData.get(0), "string");
        this.insertIntoJsonObject(dataInJson, "titleType", rowData.get(1), "string");
        this.insertIntoJsonObject(dataInJson, "primaryTitle", rowData.get(2), "string");
        this.insertIntoJsonObject(dataInJson, "originalTitle", rowData.get(3), "string");
        this.insertIntoJsonObject(dataInJson, "isAdult", rowData.get(4), "integer");
        this.insertIntoJsonObject(dataInJson, "startYear", rowData.get(5), "integer");
        this.insertIntoJsonObject(dataInJson, "endYear", rowData.get(6), "integer");
        this.insertIntoJsonObject(dataInJson, "runTimeMinutes", rowData.get(7), "integer");
        this.insertIntoJsonObject(dataInJson, "genre", rowData.get(8), "string");

        return dataInJson;
    }

    public static void main(String[] args) {
        TitleBasics test = new TitleBasics();
        System.out.println(test.getClass().getSimpleName());
    }
}
