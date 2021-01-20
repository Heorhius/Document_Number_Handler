package com.kaptsiug.study.project.util.reader;

import java.io.*;
import java.nio.file.Path;

public class FileDocReader implements IReadable {
    private static final String FILE_NOT_FOUND_EXCEPTION = "File hasn't found!";

    @Override
    public String read(String source) {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println(FILE_NOT_FOUND_EXCEPTION);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (stringBuilder.length() != 0) {
            result = stringBuilder.toString();
        }
        return result;
    }

    public String read(Path path) {
        return read(path.toString());
    }
}
