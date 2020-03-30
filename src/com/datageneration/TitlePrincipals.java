package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;

public class TitlePrincipals extends DataUnit{

    public TitlePrincipals() {
        super("title_principals_sampled.csv",
                true);
    }

    public LinkedList<JSONObject> getAllRecordsForTitleAsJson(String uniqueIdForRow) {
        LinkedList<JSONObject> dataAsJsonObjects = new LinkedList<JSONObject>();
        ArrayList<String> nameIds = DataStats.getNameConstsForTitle(uniqueIdForRow);
        for (String nameId: nameIds) {
            String principalsRetrievalId = uniqueIdForRow + "|" + nameId;
            JSONObject individualNameData = this.getSingleRecordAsJson(principalsRetrievalId);
            dataAsJsonObjects.addLast(individualNameData);
            this.removeRecordFromMemory(principalsRetrievalId);
        }
        return dataAsJsonObjects;
    }

    @Override
    public JSONObject convertToJson(String[] rowData) {
        JSONObject dataInJson = new JSONObject();

        this.insertIntoJsonObject(dataInJson, "tconst", rowData[0], "string");
        this.insertIntoJsonObject(dataInJson, "ordering", rowData[1], "integer");
        this.insertIntoJsonObject(dataInJson, "nconst", rowData[2], "string");
        this.insertIntoJsonObject(dataInJson, "category", rowData[3], "string");
        this.insertIntoJsonObject(dataInJson, "job", rowData[4], "string");
        this.insertIntoJsonObject(dataInJson, "characters", rowData[5], "string");

        return dataInJson;
    }
}
