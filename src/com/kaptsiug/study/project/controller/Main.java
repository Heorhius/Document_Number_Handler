package com.kaptsiug.study.project.controller;

import com.kaptsiug.study.project.exception.IllegalStringIndexException;
import com.kaptsiug.study.project.logic.DocumentHandler;
import com.kaptsiug.study.project.util.Parser;
import com.kaptsiug.study.project.util.Validator;
import com.kaptsiug.study.project.util.reader.IReadable;
import com.kaptsiug.study.project.util.reader.ReaderCreator;
import com.kaptsiug.study.project.util.reader.ReaderType;

public class Main {

    public static void main(String[] args) {

        ReaderCreator readerCreator = new ReaderCreator();
        IReadable reader = readerCreator.createReader(ReaderType.FILE);
        String result = reader.read("test.txt");
        String[] parseResults = Parser.parseDocument(result);

        if (parseResults.length != 0) {
            for (int i = 0; i < parseResults.length; i++) {
                if (Validator.validateDocNumber(parseResults[i])) {
                    String stringWithHiredElements = null;
                    try {
                        stringWithHiredElements = DocumentHandler.hideSomeCharsInDocument(parseResults[i], 5, 7);
                        stringWithHiredElements = DocumentHandler.hideSomeCharsInDocument(stringWithHiredElements, 14, 16);
                    } catch (IllegalStringIndexException e) {
                        e.getMessage();
                        e.printStackTrace();
                    }

                    System.out.println(stringWithHiredElements);

                    System.out.println(DocumentHandler.getLettersFromDocNumber(parseResults[i]));

                } else System.out.printf("Couldn't validate value: %s\n", parseResults[i]);
            }
        }

    }
}
