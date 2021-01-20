package com.kaptsiug.study.project.logic;

import com.kaptsiug.study.project.exception.IllegalStringIndexException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentHandler {
    private static final String INCORRECT_INDEXES_EXCEPTION = "Incorrect indexes were input";

    public static String hideSomeCharsInDocument(String value, int startIndex, int endIndex) throws IllegalStringIndexException {
        if (startIndex < 0 || endIndex > value.length() - 1 || startIndex > endIndex) {
            throw new IllegalStringIndexException(INCORRECT_INDEXES_EXCEPTION);
        }
        StringBuilder stringBuilder = new StringBuilder(value);

        for (int i = startIndex; i <= endIndex; i++) {
            stringBuilder.replace(i, i + 1, "*");
        }
        return stringBuilder.toString();
    }

    public static String getLettersFromDocNumber(String value) {
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher(value);
        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (stringBuilder.length() != 0) {
                stringBuilder.append("/");
            }
            stringBuilder.append(value, start, end);
        }
        return stringBuilder.toString();
    }
}
