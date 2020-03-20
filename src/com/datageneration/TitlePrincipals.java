package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitlePrincipals extends DataUnit{

    public TitlePrincipals() {}

    public TitlePrincipals(String _titleId) {
        this.setTitleId(_titleId);
        this.setFileName("title_principals.csv");
        this.initializeFileData();
        this.openCsvFile();
    }

    @Override
    public JSONObject convertToJson(ArrayList<String> rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "tconst", rowData.get(0), "string");
        this.insertIntoJsonObject(dataInJson, "ordering", rowData.get(1), "integer");
        this.insertIntoJsonObject(dataInJson, "nconst", rowData.get(2), "string");
        this.insertIntoJsonObject(dataInJson, "category", rowData.get(3), "string");
        this.insertIntoJsonObject(dataInJson, "job", rowData.get(4), "string");
        this.insertIntoJsonObject(dataInJson, "characters", rowData.get(5), "string");

        return dataInJson;
    }

    public static void main(String[] args) {
        TitlePrincipals test = new TitlePrincipals("tt0000001");
        System.out.println(test.getDataAsJson());
    }
}
