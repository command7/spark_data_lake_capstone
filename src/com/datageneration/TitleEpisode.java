package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitleEpisode extends DataUnit {

    public TitleEpisode() {
        super("title_episodes.csv");
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
}
