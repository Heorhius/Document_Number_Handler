package com.kaptsiug.study.project.util.reader;

import java.util.Scanner;

public class ConsoleReader implements IReadable {

    private static final String DEFAULT_STRING_VALUE = "";
    private static final String LOG_READ_FROM_CONSOLE = "Read value from console";

    @Override
    public String read(String source) {
        String value = DEFAULT_STRING_VALUE;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            value = scanner.next();
        }
        System.out.println(LOG_READ_FROM_CONSOLE);
        return value;
    }
}
