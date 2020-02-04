package com.datageneration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.ArrayList;

public class TitleRating {
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

    public void setTitleId(String _titleId) {
        this.titleId = _titleId;
    }

    public void setFileName(String _fileName) {
        this.fileName = _fileName;
    }

    public void setFileData(ArrayList<ArrayList> _fileData) {
        this.fileData = _fileData;
    }

    public TitleRating(String _titleId) {
        this.setTitleId(_titleId);
        this.setFileName("title_ratings.csv");
        fileData = new ArrayList<ArrayList>();
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




    public static void main(String[] args) {
        TitleRating test = new TitleRating("tt0000001");
        test.openCsvFile();
        System.out.println(test.getFileData());
    }

}
