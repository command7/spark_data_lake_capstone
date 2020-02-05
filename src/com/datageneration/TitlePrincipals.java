package com.datageneration;

public class TitlePrincipals extends DataUnit{

    public TitlePrincipals(String _titleId) {
        this.setTitleId(_titleId);
        this.setFileName("title_principals.csv");
        this.initializeFileData();
        this.openCsvFile();
        this.filter();
    }

    public static void main(String[] args) {
        TitlePrincipals test = new TitlePrincipals("tt0000001");
        System.out.println(test);
    }
}
