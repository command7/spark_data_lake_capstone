package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;

public class NameBasic extends DataUnit{

    public NameBasic() {
        super("name_basics.csv");
    }

    public LinkedList<JSONObject> getAllRecordsForTitleAsJson(String uniqueIdForRow) {
        LinkedList<JSONObject> dataAsJsonObjects = new LinkedList<JSONObject>();
        ArrayList<String> nameIds = DataStats.getNameConstsForTitle(uniqueIdForRow);
        for (String nameId: nameIds) {
            JSONObject individualNameData = this.getSingleRecordAsJson(nameId);
            dataAsJsonObjects.addLast(individualNameData);
            this.removeRecordFromMemory(nameId);
        }
        return dataAsJsonObjects;
    }

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
