package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class NameBasic extends DataUnit{

    public NameBasic() {}

    public NameBasic(String _nameId) {
        this.setTitleId(_nameId);
        this.setFileName("name_basics.csv");
        this.initializeFileData();
        this.openCsvFile();
    }

    public static void main(String[] args) {
        NameBasic test = new NameBasic("nm0000001");
        System.out.println(test.getDataAsJson());
    }
}
