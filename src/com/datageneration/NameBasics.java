package com.datageneration;

public class NameBasics extends DataUnit{

    public NameBasics(String _nameId) {
        this.setTitleId(_nameId);
        this.setFileName("name_basics.csv");
        this.initializeFileData();
        this.openCsvFile();
        this.filter();
    }

    public static void main(String[] args) {
        NameBasics test = new NameBasics("nm0000001");
        System.out.println(test);
    }
}
