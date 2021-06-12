package com.kanaa.crypto.basic.cryptanalysis;

import com.kanaa.Resources;
import com.kanaa.common.Logger;
import com.kanaa.common.StringFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Alexander Kanunnikov
 */

public class SymbolReplacer {

    private static final Logger LOGGER = new Logger();

    private String cipherText;

    private DecryptingText decryptingText;

    private String fileName;

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    interface Command {
        void run(DecryptingText decryptingText);

        static Command parse(String commandLine) {
            if (commandLine.startsWith("r ") || commandLine.startsWith("replace ") ) {
                String operands = commandLine.replace("replace ","");
                String first = operands.substring(0, operands.indexOf("->"));
                String second = operands.substring(operands.indexOf("->") + 2);
                return new Replace(first, second);
            } else {
                throw new IllegalArgumentException(
                        String.format("Не удалось распознать команду (%s)", commandLine)
                );
            }
        }
    }

    static class Replace implements Command {

        private String cipherSubStr;
        private String openSubStr;

        public Replace(String cipherSubStr, String openSubStr) {
            this.cipherSubStr = cipherSubStr;
            this.openSubStr = openSubStr;
        }

        @Override
        public void run(DecryptingText decryptingText) {
            decryptingText.replace(cipherSubStr, openSubStr);
        }
    }

    public SymbolReplacer(String cipherText, String fileName) {
        this.cipherText = cipherText;
        this.decryptingText = new DecryptingText(cipherText, "");
        this.fileName = fileName;
    }

    public void beginDecrypt() throws IOException {
//        if ((new File(fileName)).exists()) {
//            continueDecrypt();
//        } else {
            decryptingText.print();
//        }
        Command command = Command.parse(reader.readLine());
        while (command != null) {
            command.run(decryptingText);
            decryptingText.print();
            command = Command.parse(reader.readLine());
        }
    }

    private void continueDecrypt() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))){
            List<String> strings = stream.collect(Collectors.toList());
            strings.forEach(LOGGER::print);
            decryptingText = new DecryptingText(cipherText, strings.get(strings.size()-1));
        }
    }

    public static void main(String[] args) {
        String cipherText = "";
        try {
            String fileName = Resources.path("cipher.txt");
            cipherText = (new StringFromFile(fileName, "Cp866")).value();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String decryptingFileName = Resources.path("decrypting.txt");
        SymbolReplacer replacer = new SymbolReplacer(cipherText, decryptingFileName);
        try {
            replacer.beginDecrypt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}