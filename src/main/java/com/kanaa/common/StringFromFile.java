package com.kanaa.common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Содержимое файла в виде строки
 *
 * @author Alexander Kanunnikov
 */

public class StringFromFile {

    private final String value;

    public StringFromFile(String fileName) throws IOException {
        this(fileName, Charset.defaultCharset());
    }

    public StringFromFile(String fileName, String charsetName) throws IOException {
        this(fileName, Charset.forName(charsetName));
    }


    public StringFromFile(String fileName, Charset charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(fileName), charset)) {
            stream.forEach(sb::append);
        }
        value = sb.toString();
    }

    public String value() {
        return value;
    }
}