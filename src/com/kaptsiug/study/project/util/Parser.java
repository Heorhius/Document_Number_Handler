package com.kaptsiug.study.project.util;

public class Parser {

    /*
    Method is designed to get separated documents numbers
    Expected values separated with ";".
    Example: "DOC001;DOC002:DOC003".
     */
    public static String[] parseDocument(String value) {
        String docNumbers = value.trim();
        return value.split(";");

    }
}
