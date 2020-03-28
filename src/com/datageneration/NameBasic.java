package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class NameBasic extends DataUnit{

    public NameBasic() {
        this.setFileName("name_basics.csv");
        this.initializeFileData();
        this.readDataContentsToMemory();
    }

    //    public void addIndividualFileData(ArrayList fileRecord) {
//        this.getAllFileData().add(fileRecord);
//    }
//
//    public void gatherInfo() {
//        ArrayList<String> nameIds = DataStats.getNameConstsForTitle(this.getTitleId());
//        for (String nameId: nameIds) {
//            NameBasic individualNameBasic = new NameBasic(nameId);
//            TreeMap<String, ArrayList<String>> individualFileData = individualNameBasic.getAllFileData();
//            for (ArrayList rowData: individualFileData) {
//                this.addIndividualFileData(rowData);
//            }
//        }
//    }

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
}
