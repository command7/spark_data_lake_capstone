package com.datageneration;

import java.util.ArrayList;

public class NameBasics extends DataUnit{

    private String titleId;

    public NameBasics(String _titleId) {
        this.setTitleId(_titleId);
        this.initializeFileData();
        this.gatherInfo();
    }

    public void addIndividualFileData(ArrayList fileRecord) {
        this.getFileData().add(fileRecord);
    }

    public void gatherInfo() {
        ArrayList<String> nameIds = DataStats.getNameConstsForTitle(this.getTitleId());
        for (String nameId: nameIds) {
            NameBasic individualNameBasic = new NameBasic(nameId);
            ArrayList<ArrayList> individualFileData = individualNameBasic.getFileData();
            for (ArrayList rowData: individualFileData) {
                this.addIndividualFileData(rowData);
            }
        }
    }

    public static void main(String[] args) {
        NameBasics test = new NameBasics("tt0000105");
        System.out.println(test);
    }
}
