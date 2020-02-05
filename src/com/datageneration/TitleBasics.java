package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitleBasics extends DataUnit{

    public TitleBasics(String _titleId) {
        this.setTitleId(_titleId);
        this.setFileName("title_basics.csv");
        this.initializeFileData();
        this.openCsvFile();
        this.filter();
    }

    @Override
    public JSONObject convertToJson(ArrayList<String> rowData) {
        JSONObject dataInJson = new JSONObject();

        dataInJson.put("tconst", rowData.get(0));
        dataInJson.put("titleType", rowData.get(1));
        dataInJson.put("primaryTitle", rowData.get(2));
        dataInJson.put("originalTitle", rowData.get(3));
        dataInJson.put("isAdult", Integer.valueOf(rowData.get(4)));
        dataInJson.put("startYear", Integer.valueOf(rowData.get(5)));
        dataInJson.put("endYear", rowData.get(6));
        dataInJson.put("runTimeMinutes", Integer.valueOf(rowData.get(7)));

        return dataInJson;
    }

    public static void main(String[] args) {
        TitleBasics test = new TitleBasics("tt0000001");
        System.out.println(test.getDataAsJson());
    }
}
