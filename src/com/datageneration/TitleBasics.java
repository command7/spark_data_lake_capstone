package com.datageneration;

public class TitleBasics extends DataUnit{

    public TitleBasics(String _titleId) {
        this.setTitleId(_titleId);
        this.setFileName("title_basics.csv");
        this.initializeFileData();
        this.openCsvFile();
        this.filter();
    }

    public static void main(String[] args) {
        TitleBasics test = new TitleBasics("tt0000001");
        System.out.println(test);
    }
}
