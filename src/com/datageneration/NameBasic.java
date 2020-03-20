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
        dataInJson.put("nconst", rowData.get(0));
        dataInJson.put("primaryName", rowData.get(1));
        dataInJson.put("birthYear", Integer.valueOf(rowData.get(2)));
        dataInJson.put("deathYear", Integer.valueOf(rowData.get(3)));
        dataInJson.put("primaryProfession", rowData.get(4));
        dataInJson.put("knownForTitles", rowData.get(5));
        return dataInJson;
    }

    public static void main(String[] args) {
        NameBasic test = new NameBasic("nm0000001");
        System.out.println(test.getDataAsJson());
    }
}
