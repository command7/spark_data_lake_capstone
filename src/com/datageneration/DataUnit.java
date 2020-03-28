package com.datageneration;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeMap;

public abstract class DataUnit {

    private String fileName;
    private boolean preProcessUniqueIdFlag = false;
    private TreeMap<String, ArrayList<String>> fileData;

    public String getFileName() {
        return this.fileName;
    }

    public TreeMap<String, ArrayList<String>> getAllFileData() {
        return this.fileData;
    }

    public int getNumberOfRecords() {
        return this.getAllFileData().size();
    }

    public String getAbsoluteFilePath(String fileToOpen) {
        return "Data/" + fileToOpen;
    }

    public ArrayList<String> getRowDataFromFile(String itemId) {
        return this.getAllFileData().get(itemId);
    }

    public void initializeFileData() {
        this.fileData = new TreeMap<String, ArrayList<String>>();
    }

    public void setFileName(String _fileName) {
        this.fileName = _fileName;
    }

    public void setPreProcessUniqueIdFlag(boolean flagValue) {
        this.preProcessUniqueIdFlag = flagValue;
    }

    public void readDataContents() {
        String pathToCsvFile = this.getAbsoluteFilePath(this.getFileName());
        String dataLine;
        int lineNumber = 1;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsvFile));
            while ((dataLine = csvReader.readLine()) != null) {
                if (lineNumber == 1) {
                    lineNumber += 1;
                    continue;
                }
                ArrayList<String> rowDataList = new ArrayList<String>();
                String [] rowDataArray = dataLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                for (String s : rowDataArray) {
                    rowDataList.add(s.replace("\"", ""));
                }
                if (!preProcessUniqueIdFlag) {
                    fileData.put(rowDataList.get(0), rowDataList);
                }
                else {
                    String rowUniqueId = rowDataList.get(0) + "|" + rowDataList.get(2);
                    fileData.put(rowUniqueId, rowDataList);
                }
            }
            csvReader.close();
        }
        catch (Exception ex) {};
    }

    public boolean isValueNull(String valueToCheckIfNull) {
        return valueToCheckIfNull.equals("\\\\N") || valueToCheckIfNull.equals("\\N");
    }

    public void insertIntoJsonObject(JSONObject jsonObject, String keyToInsert,
                                      String valueToInsert, String dataType) {
        if (this.isValueNull(valueToInsert)) {
            jsonObject.put(keyToInsert, JSONObject.NULL);
        }
        else {
            switch (dataType) {
                case "integer":
                    jsonObject.put(keyToInsert, Integer.valueOf(valueToInsert));
                    break;

                case "string":
                    jsonObject.put(keyToInsert, valueToInsert);
                    break;

                case "decimal":
                    jsonObject.put(keyToInsert, Double.valueOf(valueToInsert));
                    break;

            }
        }

    }
//    public String toString() {
//        String outputString = "";
//        for (int recordIndex = 0; recordIndex < this.getNumberOfRecords(); recordIndex++) {
//            ArrayList recordData = this.getRowDataFromFile(recordIndex);
//            for (int recordDataIndex = 0; recordDataIndex < recordData.size(); recordDataIndex++) {
//                outputString += (String)recordData.get(recordDataIndex) + " ";
//            }
//            outputString += "\n";
//        }
//        return outputString;
//    }

    public JSONObject convertToJson(ArrayList<String> rowData) {
        return null;
    }

//    public ArrayList<JSONObject> getDataAsJson() {
//        ArrayList<JSONObject> jsonData = new ArrayList<JSONObject>();
//        for (int recordIndex = 0; recordIndex < this.getNumberOfRecords(); recordIndex++){
//            jsonData.add(convertToJson(this.getRowDataFromFile(recordIndex)));
//        }
//        return jsonData;
//    }

}
