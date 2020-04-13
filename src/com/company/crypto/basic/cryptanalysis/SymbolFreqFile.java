package com.company.crypto.basic.cryptanalysis;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alexander Kanunnikov
 */

public class SymbolFreqFile {

    public static void main(String[] args) {
        HashMap<String, Integer> countMap = new HashMap<>(100);
        int allCount = 0;
        try (InputStream is = new FileInputStream("C:\\text.txt")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "Cp1251"));
            int cp;
            Pattern pattern = Pattern.compile("[ А-Я]");
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
        //
        TreeMap<Float, String> freqMap = new TreeMap<>();
        if (allCount > 0) {
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                freqMap.put(entry.getValue().floatValue() / (float) allCount, entry.getKey());
            }
        }
        try (OutputStream os = new FileOutputStream("C:\\freq.txt")) {
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
    }

}