package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitleEpisode extends DataUnit {

    public TitleEpisode() {}

    public TitleEpisode(String _titleId) {
    this.setTitleId(_titleId);
    this.setFileName("title_episodes.csv");
    this.initializeFileData();
    this.openCsvFile();
    }

    @Override
    public JSONObject convertToJson(ArrayList<String> rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "tconst", rowData.get(0), "string");
        this.insertIntoJsonObject(dataInJson, "parentTconst", rowData.get(1), "string");
        this.insertIntoJsonObject(dataInJson, "seasonNumber", rowData.get(2), "integer");
        this.insertIntoJsonObject(dataInJson, "episodeNumber", rowData.get(3), "integer");

        return dataInJson;
    }

    public static void main(String[] args) {
        TitleEpisode test = new TitleEpisode("tt0041951");
        System.out.println(test.getDataAsJson());
    }
}
