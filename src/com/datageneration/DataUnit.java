package com.datageneration;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public abstract class DataUnit {

    private String titleId;
    private String fileName;
    private ArrayList<ArrayList> fileData;

    public String getTitleId() {
        return this.titleId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public ArrayList<ArrayList> getFileData() {
        return this.fileData;
    }

    public int getNumberOfRecords() {
        return this.getFileData().size();
    }

    public String getAbsoluteFilePath(String fileToOpen) {
        return "Data/" + fileToOpen;
    }

    public ArrayList getRowDataFromFile(int itemIndex) {
        return this.getFileData().get(itemIndex);
    }

    public String getTitleIdAtIndex(int itemIndex) {
        return String.valueOf(this.getRowDataFromFile(itemIndex).get(0));
    }

    public void initializeFileData() {
        this.fileData = new ArrayList<ArrayList>();
    }

    public void setTitleId(String _titleId) {
        this.titleId = _titleId;
    }

    public void setFileName(String _fileName) {
        this.fileName = _fileName;
    }

    public void setFileData(ArrayList<ArrayList> _fileData) {
        this.fileData = _fileData;
    }

    public void openCsvFile() {
        // Check if file is present
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
                ArrayList rowDataList = new ArrayList();
                String [] rowDataArray = dataLine.split(",");
                for (int rowDataArrayIndex = 0; rowDataArrayIndex < rowDataArray.length; rowDataArrayIndex++) {
                    rowDataList.add(rowDataArray[rowDataArrayIndex].replace("\"", ""));
                }
                fileData.add(rowDataList);
            }
            csvReader.close();
        }
        catch (Exception ex) {};
    }

    public int binarySearchForItem(String filterId) {
        int startingPointer = 0;
        int endingPointer = this.getNumberOfRecords() - 1;
        int foundElementIndex = -1;
        int midPointer;
        while (startingPointer <= endingPointer) {
            midPointer = (endingPointer + startingPointer) / 2;
            String currentTitleId = this.getTitleIdAtIndex(midPointer);
            if (filterId.equals(currentTitleId)) {
                foundElementIndex = midPointer;
                break;
            }
            else if (currentTitleId.compareTo(filterId) < 0) {
                startingPointer = midPointer + 1;
            }
            else {
                endingPointer = midPointer - 1;
            }
        }
        return foundElementIndex;
    }

    public int findElementStartingPosition(int elementRangeStartIndex, String elementValue) {
        while (elementRangeStartIndex > 0) {
            int previousElementRangeIndex = elementRangeStartIndex - 1;
            String previousTitleId = this.getTitleIdAtIndex(previousElementRangeIndex);
            if (!previousTitleId.equals(elementValue)) {
                break;
            }
            else {
                elementRangeStartIndex = previousElementRangeIndex;
            }
        }
        return elementRangeStartIndex;
    }

    public int findElementEndingPosition(int elementRangeEndIndex, String elementValue) {
        while(elementRangeEndIndex < this.getNumberOfRecords()) {
            int nextElementRangeIndex = elementRangeEndIndex + 1;
            String nextTitleId = this.getTitleIdAtIndex(nextElementRangeIndex);
            if (!nextTitleId.equals(elementValue)) {
                break;
            }
            else {
                elementRangeEndIndex = nextElementRangeIndex;
            }
        }
        return elementRangeEndIndex;
    }

    public void updateFilteredData(int foundElementIndex) {
        String elementValue = this.getTitleIdAtIndex(foundElementIndex);
        int elementRangeStartIndex = this.findElementStartingPosition(foundElementIndex, elementValue);
        int elementRangeEndIndex = this.findElementEndingPosition(foundElementIndex, elementValue);

        ArrayList<ArrayList> filteredFileData = new ArrayList<ArrayList>();
        for(int recordIndex = elementRangeStartIndex; recordIndex <= elementRangeEndIndex; recordIndex++) {
            filteredFileData.add(this.getRowDataFromFile(recordIndex));
        }

        this.setFileData(filteredFileData);
    }

    public void filter() {
        String filterId = this.getTitleId();
        int foundElementIndex = this.binarySearchForItem(filterId);
        if (foundElementIndex == -1) {
            // No such element found
            this.initializeFileData();
        }
        else {
            this.updateFilteredData(foundElementIndex);
        }
    }

    public String toString() {
        String outputString = "";
        for (int recordIndex = 0; recordIndex < this.getNumberOfRecords(); recordIndex++) {
            ArrayList recordData = this.getRowDataFromFile(recordIndex);
            for (int recordDataIndex = 0; recordDataIndex < recordData.size(); recordDataIndex++) {
                outputString += (String)recordData.get(recordDataIndex) + " ";
            }
            outputString += "\n";
        }
        return outputString;
    }

    public JSONObject convertToJson(ArrayList<String> rowData) {
        return null;
    }

    public ArrayList<JSONObject> getDataAsJson() {
        ArrayList<JSONObject> jsonData = new ArrayList<JSONObject>();
        for (int recordIndex = 0; recordIndex < this.getNumberOfRecords(); recordIndex++){
            jsonData.add(convertToJson(this.getRowDataFromFile(recordIndex)));
        }
        return jsonData;
    }

}
