package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitleRating extends DataUnit {

    public TitleRating() {}

    public TitleRating(String _titleId) {
        this.setTitleId(_titleId);
        this.setFileName("title_ratings.csv");
        this.initializeFileData();
        this.openCsvFile();
    }

    @Override
    public JSONObject convertToJson(ArrayList<String> rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "tconst", rowData.get(0), "string");
        this.insertIntoJsonObject(dataInJson, "averageRating", rowData.get(1), "decimal");
        this.insertIntoJsonObject(dataInJson, "numVotes", rowData.get(2), "decimal");

        return dataInJson;
    }

    public static void main(String[] args) {
        TitleRating test = new TitleRating("tt0000002");
        System.out.println(test);
    }

}
