package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitleRating extends DataUnit {

    public TitleRating() {
        super("title_ratings_sampled.csv");
    }

    @Override
    public JSONObject convertToJson(String[] rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "tconst", rowData[0], "string");
        this.insertIntoJsonObject(dataInJson, "averageRating", rowData[1], "decimal");
        this.insertIntoJsonObject(dataInJson, "numVotes", rowData[2], "decimal");

        return dataInJson;
    }
}
