package com.datageneration;

import java.util.ArrayList;

public class NameBasics {

    private String titleId;
    private ArrayList<ArrayList> fileData;

    public NameBasics(String _titleId) {
        this.setTitleId(_titleId);
    }

    public void setTitleId(String _titleId) {
        this.titleId = _titleId;
    }
}
