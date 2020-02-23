package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitleRating extends DataUnit {

    public TitleRating(String _titleId) {
        this.setTitleId(_titleId);
        this.setFileName("title_ratings.csv");
        this.initializeFileData();
        this.openCsvFile();
    }

    @Override
    public JSONObject convertToJson(ArrayList<String> rowData) {
        JSONObject dataInJson = new JSONObject();

        dataInJson.put("tconst", rowData.get(0));
        dataInJson.put("averageRating", Double.valueOf(rowData.get(1)));
        dataInJson.put("numVotes", Double.valueOf(rowData.get(2)));

        return dataInJson;
    }

    public static void main(String[] args) {
        TitleRating test = new TitleRating("tt0000002");
        System.out.println(test);
    }

}
