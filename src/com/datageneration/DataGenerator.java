package com.datageneration;

import org.json.JSONObject;

import java.util.ArrayList;

public class DataGenerator {


    public int getRandomNumber(int endingNumber) {
       return (int)(Math.random()*((endingNumber)+1));
    }

    public DataGenerator() {
    }

    public static void main(String[] args) {

    }

}
