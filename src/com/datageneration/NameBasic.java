package com.datageneration;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class NameBasic extends DataUnit{

    private BufferedWriter errorWriter;

    public BufferedWriter getErrorWriter() {
        return errorWriter;
    }

    private void initializeErrorWriter() {
        try {
            this.errorWriter = new BufferedWriter(
                    new FileWriter(new File("RealTimeData/Errors/NameBasicsErrors.txt"), true));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public NameBasic() {
        super("name_basics.csv");
        initializeErrorWriter();
    }

    public LinkedList<JSONObject> getAllRecordsForTitleAsJson(String uniqueIdForRow) {
        LinkedList<JSONObject> dataAsJsonObjects = new LinkedList<JSONObject>();
        ArrayList<String> nameIds = DataStats.getNameConstsForTitle(uniqueIdForRow);
        for (String nameId: nameIds) {
            JSONObject individualNameData = this.getSingleRecordAsJson(nameId);
            if (individualNameData == null) {
                try {
                    this.getErrorWriter().write(nameId);
                    this.getErrorWriter().newLine();
                    this.getErrorWriter().flush();
                    System.out.println(nameId);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            dataAsJsonObjects.addLast(individualNameData);
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
