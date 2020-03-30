package com.datageneration;

import org.json.JSONObject;

import java.io.*;
import java.util.TreeMap;

public abstract class DataUnit {

    private String fileName;
    private boolean preProcessUniqueIdFlag = false;
    private TreeMap<String, String[]> fileData;

    public DataUnit(String originalCsvDataFileName) {
        this.setFileName(originalCsvDataFileName);
        this.initializeFileData();
        this.readDataContentsToMemory();
    }

    public DataUnit(String originalCsvDataFileName,
                    boolean preProcessFlag) {
        this.setPreProcessUniqueIdFlag(preProcessFlag);
        this.setFileName(originalCsvDataFileName);
        this.initializeFileData();
        this.readDataContentsToMemory();
    }

    public String getFileName() {
        return this.fileName;
    }

    public TreeMap<String, String[]> getAllFileData() {
        return this.fileData;
    }

    public int getNumberOfRecords() {
        return this.getAllFileData().size();
    }

    public String getAbsoluteFilePath(String fileToOpen) {
        return "Data/" + fileToOpen;
    }

    public void initializeFileData() {
        this.fileData = new TreeMap<String, String[]>();
    }

    public void setFileName(String _fileName) {
        this.fileName = _fileName;
    }

    public void setPreProcessUniqueIdFlag(boolean flagValue) {
        this.preProcessUniqueIdFlag = flagValue;
    }

    public String[] getRecord(String uniqueRowId) {
        return this.getAllFileData().get(uniqueRowId);
    }

    public void readDataContentsToMemory() {
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
                String[] rowDataArray = dataLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                for(int rowDataIndex = 0; rowDataIndex < rowDataArray.length; rowDataIndex++) {
                    rowDataArray[rowDataIndex] = rowDataArray[rowDataIndex].replace("\"", "");
                }
                if (!preProcessUniqueIdFlag) {
                    fileData.put(rowDataArray[0], rowDataArray);
                } else {
                    String rowUniqueId = rowDataArray[0] + "|" + rowDataArray[2];
                    fileData.put(rowUniqueId, rowDataArray);
                }
            }
            csvReader.close();
        } catch (Exception ex) { }
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

    public JSONObject convertToJson(String[] rowData) {
        return null;
    }

    public JSONObject getSingleRecordAsJson(String uniqueIdForRow) {
        String [] rowData = this.getRecord(uniqueIdForRow);
        if (rowData == null) {
            return null;
        }
        this.removeRecordFromMemory(uniqueIdForRow);
        return this.convertToJson(rowData);
    }

    public void removeRecordFromMemory(String idToDelete) {
        this.getAllFileData().remove(idToDelete);
    }
}
