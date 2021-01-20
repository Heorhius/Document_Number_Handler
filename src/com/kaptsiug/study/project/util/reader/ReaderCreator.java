package com.kaptsiug.study.project.util.reader;

public class ReaderCreator {
    private static final String ILLEGAL_READER_TYPE_EXCEPTION = "Illegal reader type!";
    private IReadable reader;

    public IReadable createReader(ReaderType readerType) {
        switch (readerType) {
            case CONSOLE: {
                reader = new ConsoleReader();
                break;
            }
            case FILE: {
                reader = new FileDocReader();
                break;
            }
            case DATABASE: {
                reader = new DBReader();
            }
        }
        return reader;
    }

}
