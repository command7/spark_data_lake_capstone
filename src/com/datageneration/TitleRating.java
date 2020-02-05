package com.datageneration;

public class TitleRating extends DataUnit {

    public TitleRating(String _titleId) {
        this.setTitleId(_titleId);
        this.setFileName("title_ratings.csv");
        this.initializeFileData();
        this.openCsvFile();
        this.filter();
    }

    public static void main(String[] args) {
        TitleRating test = new TitleRating("tt0000002");
        System.out.println(test);
    }

}
