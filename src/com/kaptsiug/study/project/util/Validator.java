package com.kaptsiug.study.project.util;

import com.kaptsiug.study.project.exception.IllegalDocumentTypeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String INCORRECT_DOCUMENT_TYPE_EXCEPTION = "Incorrect document type in %s";
    private static final String INCORRECT_DOCUMENT_SIZE_EXCEPTION = "Incorrect size in document number: %s";

    public static boolean validateDocNumber(String value) throws IllegalDocumentTypeException {
        if (!Pattern.matches("^.{22}$",value)) {
            throw new IllegalDocumentTypeException(String.format(INCORRECT_DOCUMENT_SIZE_EXCEPTION, value));
        }
        if (Pattern.matches("^1{4}.*$",value)) {
            throw new IllegalDocumentTypeException(String.format(INCORRECT_DOCUMENT_TYPE_EXCEPTION, value));
        }
        Pattern pattern = Pattern.compile("^(\\d{4}-[A-Z]{3}-){2}(\\d[A-Z]){2}$");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
