package com.datageneration;

import org.json.JSONObject;

public class TitleEpisode extends DataUnit {

    public TitleEpisode() {
        super("title_episodes.csv");
    }

    @Override
    public JSONObject convertToJson(String[] rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "tconst", rowData[0], "string");
        this.insertIntoJsonObject(dataInJson, "parentTconst", rowData[1], "string");
        this.insertIntoJsonObject(dataInJson, "seasonNumber", rowData[2], "integer");
        this.insertIntoJsonObject(dataInJson, "episodeNumber", rowData[3], "integer");

        return dataInJson;
    }
}
