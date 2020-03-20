package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitleEpisode extends DataUnit {

    public TitleEpisode(String _titleId) {
    this.setTitleId(_titleId);
    this.setFileName("title_episodes.csv");
    this.initializeFileData();
    this.openCsvFile();
    }

    @Override
    public JSONObject convertToJson(ArrayList<String> rowData) {
        JSONObject dataInJson = new JSONObject();
        dataInJson.put("tconst", rowData.get(0));
        dataInJson.put("parentTconst", rowData.get(1));
        dataInJson.put("seasonNumber", rowData.get(2));
        dataInJson.put("episodeNumber", rowData.get(3));
        return dataInJson;
    }
}
