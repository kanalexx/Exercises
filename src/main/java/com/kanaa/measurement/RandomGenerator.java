package com.kanaa.measurement;

import com.kanaa.common.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Kanunnikov
 */

public class RandomGenerator {

    private static final Logger logger = new Logger();

    /**
     * пока только положительные и без проверок
     */
    public static List<Integer> generateIntegers(int count, int from, int to) {
        List<Integer> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add((int) (Math.random()*(to - from) + from));
        }
        return list;
    }

    private static void saveToFile(List<Integer> list, String filePath) throws IOException {
        try (OutputStream os = new FileOutputStream(filePath);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os))
        ) {
            for (Integer value : list) {
                writer.write(value.toString() + "\n");
            }
        }
    }

    private static void generateToFile(int count) throws IOException {
        final String resources = System.getProperty("user.dir")+"\\resources\\";
        final int from = 0;
        final int to = count;
        List<Integer> list = RandomGenerator.generateIntegers(count, from, to);
        String fileName = count + ".txt";
        saveToFile(list, resources + fileName);
        logger.logf("Файл %s сгенерирован", fileName);
    }

    public static void main(String[] args) {
        logger.log("Генерация файлов с последовательностью целых чисел:");
        try {
            generateToFile(10);
            generateToFile(100);
            generateToFile(1000);
            generateToFile(10000);
            generateToFile(100000);
            generateToFile(1000000);
            generateToFile(10000000);
            logger.log("ГОТОВО!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}