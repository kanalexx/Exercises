package com.company.crypto.basic.cryptanalysis;

import com.company.common.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * @author Alexander Kanunnikov
 */

public class SymbolFreqFile {

    public static void main(String[] args) {
        final String textFileName = "C:\\text.txt";
        final String freqFileName = "C:\\freq.txt";
        final String symbolMask = "[ А-Я]";
        //
        HashMap<String, Integer> countMap = new HashMap<>(100);
        int allCount = 0;
        Logger logger = new Logger();
        logger.logf("Чтение файла с текстом %s", textFileName);
        try (InputStream is = new FileInputStream(textFileName)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "Cp1251"));
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.logf("Найдено %s символов, удовлетворяющих маске", allCount, symbolMask);
        //
        logger.log("Подсчет частот");
        TreeMap<Float, String> freqMap = new TreeMap<>();
        if (allCount > 0) {
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                freqMap.put(entry.getValue().floatValue() / (float) allCount, entry.getKey());
            }
        }
        logger.logf("Сохранение частот в файл %s", freqFileName);
        try (OutputStream os = new FileOutputStream(freqFileName)) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "Cp1251"));
            for (Map.Entry<Float, String> entry : freqMap.descendingMap().entrySet()) {
                writer.write(String.format("%s=%f\n", entry.getValue(), entry.getKey()));
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.log("ГОТОВО!");
    }

}