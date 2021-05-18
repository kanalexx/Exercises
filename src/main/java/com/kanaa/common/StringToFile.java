package com.kanaa.common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @author Alexander Kanunnikov
 */

public class StringToFile {

    private final String value;
    private final Path fileName;
    private final Charset charset;

    public StringToFile(String value, String fileName) {
        this(value, fileName, Charset.defaultCharset());
    }

    public StringToFile(String value, String fileName, String charsetName) {
        this(value, fileName, Charset.forName(charsetName));
    }


    public StringToFile(String value, String fileName, Charset charset) {
        this.value = value;
        this.fileName = Paths.get(fileName);
        this.charset = charset;
    }

    public void append() throws IOException {
        Files.write(fileName, Collections.singletonList(value), charset, StandardOpenOption.APPEND);
    }

    public void save() throws IOException {
        Files.write(fileName, Collections.singletonList(value), charset, StandardOpenOption.CREATE);
    }

}