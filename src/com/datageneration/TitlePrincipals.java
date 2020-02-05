package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class TitlePrincipals extends DataUnit{

    public TitlePrincipals(String _titleId) {
        this.setTitleId(_titleId);
        this.setFileName("title_principals.csv");
        this.initializeFileData();
        this.openCsvFile();
        this.filter();
    }

    @Override
    public JSONObject convertToJson(ArrayList<String> rowData) {
        JSONObject dataInJson = new JSONObject();
        dataInJson.put("tconst", rowData.get(0));
        dataInJson.put("ordering", Integer.valueOf(rowData.get(1)));
        dataInJson.put("nconst", rowData.get(2));
        dataInJson.put("category", rowData.get(3));
        dataInJson.put("job", rowData.get(4));
        dataInJson.put("characters", rowData.get(5));
        return dataInJson;
    }

    public static void main(String[] args) {
        TitlePrincipals test = new TitlePrincipals("tt0000001");
        System.out.println(test.getDataAsJson());
    }
}
