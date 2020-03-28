package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitleRating extends DataUnit {

    public TitleRating() {
        super("title_ratings.csv");
    }

    @Override
    public JSONObject convertToJson(ArrayList<String> rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "tconst", rowData.get(0), "string");
        this.insertIntoJsonObject(dataInJson, "averageRating", rowData.get(1), "decimal");
        this.insertIntoJsonObject(dataInJson, "numVotes", rowData.get(2), "decimal");

        return dataInJson;
    }
}
