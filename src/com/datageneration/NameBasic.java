package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class NameBasic extends DataUnit{

    public NameBasic() {}

    public NameBasic(String _nameId) {
        this.setTitleId(_nameId);
        this.setFileName("name_basics.csv");
        this.initializeFileData();
        this.openCsvFile();
    }

    @Override
    public JSONObject convertToJson(ArrayList<String> rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "nconst", rowData.get(0), "string");
        this.insertIntoJsonObject(dataInJson, "primaryName", rowData.get(1), "string");
        this.insertIntoJsonObject(dataInJson, "birthYear", rowData.get(2), "integer");
        this.insertIntoJsonObject(dataInJson, "deathYear", rowData.get(3), "integer");
        this.insertIntoJsonObject(dataInJson, "primaryProfession", rowData.get(4), "string");
        this.insertIntoJsonObject(dataInJson, "knownForTitles", rowData.get(5), "string");

        return dataInJson;
    }

    public static void main(String[] args) {
        NameBasic test = new NameBasic("nm0000001");
        System.out.println(test.getDataAsJson());
    }
}
