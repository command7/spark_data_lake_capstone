package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class NameBasic extends DataUnit{

    public NameBasic() {
        super("name_basics.csv");
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
        public JSONObject convertToJson(String[] rowData) {
            JSONObject dataInJson = new JSONObject();

            this.insertIntoJsonObject(dataInJson, "nconst", rowData[0], "string");
            this.insertIntoJsonObject(dataInJson, "primaryName", rowData[1], "string");
            this.insertIntoJsonObject(dataInJson, "birthYear", rowData[2], "integer");
            this.insertIntoJsonObject(dataInJson, "deathYear", rowData[3], "integer");
            this.insertIntoJsonObject(dataInJson, "primaryProfession", rowData[4], "string");
            this.insertIntoJsonObject(dataInJson, "knownForTitles", rowData[5], "string");

            return dataInJson;
        }
}
