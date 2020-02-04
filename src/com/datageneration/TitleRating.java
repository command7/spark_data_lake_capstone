package com.datageneration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.ArrayList;

public class TitleRating {
    private String titleId;
    private String fileName;


    public String getTitleId() {
        return this.titleId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setTitleId(String _titleId) {
        this.titleId = _titleId;
    }

    public void setFileName(String _fileName) {
        this.fileName = _fileName;
    }

    public TitleRating(String _titleId) {
        this.setTitleId(_titleId);
        this.setFileName("title_ratings.csv");
    }

    public String getFilePath(String fileToOpen) {
        return "Data/" + fileToOpen;
    }


}
