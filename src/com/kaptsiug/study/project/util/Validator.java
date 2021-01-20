package com.kaptsiug.study.project.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validateDocNumber(String value) {
        //Pattern pattern = Pattern.compile("^[A-Z]{4}-\\d{3}-[A-Z]{4}-\\d{3}-([A-Z]\\d){2}$");
        Pattern pattern = Pattern.compile("^(\\d{4}-[A-Z]{3}-){2}(\\d[A-Z]){2}$");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
