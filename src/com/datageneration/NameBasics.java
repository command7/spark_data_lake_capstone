package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class NameBasics extends DataUnit{

    private String titleId;

    public NameBasics() {}

    public NameBasics(String _titleId) {
        this.setTitleId(_titleId);
        this.initializeFileData();
        this.gatherInfo();
    }

    public void addIndividualFileData(ArrayList fileRecord) {
        this.getFileData().add(fileRecord);
    }

    public void gatherInfo() {
        ArrayList<String> nameIds = DataStats.getNameConstsForTitle(this.getTitleId());
        for (String nameId: nameIds) {
            NameBasic individualNameBasic = new NameBasic(nameId);
            ArrayList<ArrayList> individualFileData = individualNameBasic.getFileData();
            for (ArrayList rowData: individualFileData) {
                this.addIndividualFileData(rowData);
            }
        }
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
        NameBasics test = new NameBasics("tt0000105");
        System.out.println(test.getDataAsJson());
    }
}
