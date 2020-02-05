package com.datageneration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.ArrayList;

public class TitleRating {
    private String titleId;
    private String fileName;
    private ArrayList<ArrayList> fileData;

    public TitleRating(String _titleId) {
        this.setTitleId(_titleId);
        this.setFileName("title_ratings.csv");
        this.initializeFileData();
        this.openCsvFile();
        this.filter();
    }

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

    public String getFilePath(String fileToOpen) {
        return "Data/" + fileToOpen;
    }

    public ArrayList getItemFromFile(int itemIndex) {
        return this.getFileData().get(itemIndex);
    }

    public String getTitleIdAtIndex(int itemIndex) {
        return String.valueOf(this.getItemFromFile(itemIndex).get(0));
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
        String pathToCsvFile = this.getFilePath(this.getFileName());
        String dataLine;
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsvFile));
            while ((dataLine = csvReader.readLine()) != null) {
                ArrayList rowDataList = new ArrayList();
                String [] rowDataArray = dataLine.split(",");
                for (int rowDataArrayIndex = 0; rowDataArrayIndex < rowDataArray.length; rowDataArrayIndex++) {
                    rowDataList.add(rowDataArray[rowDataArrayIndex]);
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
        while (startingPointer < endingPointer) {
            midPointer = (endingPointer - startingPointer) / 2;
            String currentTitleId = this.getTitleIdAtIndex(midPointer);
            if (filterId.equals(currentTitleId)) {
                foundElementIndex = midPointer;
                break;
            }
            else if (currentTitleId.compareTo(filterId) > 0) {
                startingPointer = midPointer + 1;
            }
            else {
                endingPointer = midPointer - 1;
            }
        }
        return foundElementIndex;
    }

    public void filter() {
        String filterId = this.getTitleId();
        int foundElementIndex = this.binarySearchForItem(filterId);
        if (foundElementIndex == -1) {
            // No such element found
            this.initializeFileData();
        }
        else {
            // Find range of indices with this element
            int elementRangeStartIndex = foundElementIndex;
            int elementRangeEndIndex = foundElementIndex;

            // Find range starting
            while (elementRangeStartIndex > 0) {
                int previousElementRangeIndex = elementRangeStartIndex - 1;
                String previousTitleId = this.getTitleIdAtIndex(previousElementRangeIndex);
                if (!previousTitleId.equals(filterId)) {
                    break;
                }
                else {
                    elementRangeStartIndex = previousElementRangeIndex;
                }
            }

            // Find range end
            while(elementRangeEndIndex < this.getNumberOfRecords()) {
                int nextElementRangeIndex = elementRangeEndIndex + 1;
                String nextTitleId = this.getTitleIdAtIndex(nextElementRangeIndex);
                if (!nextTitleId.equals(filterId)) {
                    break;
                }
                else {
                    elementRangeEndIndex = nextElementRangeIndex;
                }
            }

            ArrayList<ArrayList> filteredFileData = new ArrayList<ArrayList>();
            for(int recordIndex = elementRangeStartIndex; recordIndex <= elementRangeEndIndex; recordIndex++) {
                filteredFileData.add(this.getItemFromFile(recordIndex));
            }

            this.setFileData(filteredFileData);
        }
    }

    public String toString() {
        String outputString = "";
        for (int recordIndex = 0; recordIndex < this.getNumberOfRecords(); recordIndex++) {
            ArrayList recordData = this.getItemFromFile(recordIndex);
            for (int recordDataIndex = 0; recordDataIndex < recordData.size(); recordDataIndex++) {
                outputString += (String)recordData.get(recordDataIndex) + " ";
            }
            outputString += "\n";
        }
        return outputString;
    }


    public static void main(String[] args) {
        TitleRating test = new TitleRating("tt0000001");

    }

}
