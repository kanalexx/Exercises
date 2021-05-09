package com.kanaa.crypto.basic.cryptanalysis;

import com.kanaa.Resources;
import com.kanaa.common.Logger;
import com.kanaa.common.Pair;
import com.kanaa.common.StringFromFile;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author Alexander Kanunnikov
 */

public class SymbolFreqFile {

    public static final Logger LOGGER = new Logger();

    private final String freqFileName;

    public SymbolFreqFile(String freqFileName) {
        this.freqFileName = freqFileName;
    }

    public SymbolFreqFile createFrom(String textFileName, String symbolMask, String charsetName) throws IOException {
        HashMap<String, Integer> countMap = new HashMap<>(100);
        int allCount = 0;
        LOGGER.logf("Чтение файла с текстом %s", textFileName);
        File textFile = new File(textFileName);
        if (!textFile.exists()) {
            LOGGER.logf("Не найден файл %s", textFileName);
            return this;
        }
        try (InputStream is = new FileInputStream(textFileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is, charsetName))
        ) {
            int cp;
            Pattern pattern = Pattern.compile(symbolMask);
            while ((cp = reader.read()) != -1) {
                String symbol = String.valueOf((char)cp);
                if (pattern.matcher(symbol).matches()) {
                    Integer count = countMap.get(symbol);
                    if (count == null) {
                        countMap.put(symbol, 1);
                    } else {
                        count += 1;
                        countMap.put(symbol, count);
                    }
                    allCount++;
                }
            }
        }
        LOGGER.logf("Найдено %s символов, удовлетворяющих маске \"%s\"", allCount, symbolMask);
        //
        LOGGER.log("Подсчет частот");
        ArrayList<Pair<String, Float>> freqList = new ArrayList<>();
        if (allCount > 0) {
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                freqList.add(new Pair<>(entry.getKey(), entry.getValue().floatValue() / (float) allCount));
            }
        }
        //
        LOGGER.logf("Сохранение частот в файл %s", freqFileName);
        freqList.sort(Collections.reverseOrder(Comparator.comparing(Pair::getSecond)));
        try (OutputStream os = new FileOutputStream(freqFileName);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "Cp1251"))
        ) {
            for (Pair<String, Float> pair : freqList) {
                writer.write(pair.toString() + "\n");
            }
        }
        //
        LOGGER.log("ГОТОВО!");
        return this;
    }

    public static void main(String[] args) {
        // Создание файла частот символов в тексте на русском языке
        SymbolFreqFile symbolFreqFile = new SymbolFreqFile(Resources.path("freq.txt"));
        try {
            symbolFreqFile.createFrom(Resources.path("text.txt"),"[ А-Я]", "Cp1251");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // получение строки из файла с зашифрованным текстом
        try {
            String cipherText = (new StringFromFile(Resources.path("cipher.txt"), "Cp866")).value();
            LOGGER.print(cipherText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // получение файла частот символов в зашифрованном тексте
        SymbolFreqFile cipherFreqFile = new SymbolFreqFile(Resources.path("freqCipher.txt"));
        try {
            cipherFreqFile.createFrom(Resources.path("cipher.txt"), ".", "Cp866");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}