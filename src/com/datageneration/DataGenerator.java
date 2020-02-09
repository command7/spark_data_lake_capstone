package com.datageneration;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DataGenerator {

    public int getRandomNumber() {
       int endingNumber = DataStats.getRemainingRecords();
        return (int)(Math.random()*((endingNumber)+1));
    }
//
//    public String getTitleIdAtIndex(String fileName, int itemIndex) {
//        int currentLineNumber = 1;
//        String outputTitleId = "";
//        String dataLine;
//        try {
//            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
//            while ((dataLine = csvReader.readLine()) != null) {
//                if (currentLineNumber == itemIndex) {
//                    outputTitleId = dataLine;
//                    break;
//                }
//                else {
//                    currentLineNumber += 1;
//                }
//            }
//            csvReader.close();
//        }
//        catch (Exception ex) {};
//        return outputTitleId;
//    }

    public String getTitleToProcess() {
        int idIndex = getRandomNumber();
        return DataStats.getIdAtIndex(idIndex);
    }



    public DataGenerator() {
    }

    public static void main(String[] args) {

    }

}
