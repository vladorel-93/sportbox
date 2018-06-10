package com.example.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 1 on 09.06.2018.
 */
public class StringParser {

    public StringParser() {
    }

    public List<String> parseHTMLStrings(String htmlString){
        String homeTeam = "";
        String awayTeam = "";
        String date = "";
        String month = "";
        String result = "";
        String[] separateWords = htmlString.split(" ");
        homeTeam = separateWords[0];
        awayTeam = separateWords[2];
        if (htmlString.matches("\\D+(d-d)\\D+")) {
            result = separateWords[3];
            date = separateWords[4];
            month = separateWords[5];
        }
        else {
            date = separateWords[3];
            month = separateWords[4];
        }
       return  Arrays.asList(homeTeam, awayTeam, date, month, result);
    }
}
