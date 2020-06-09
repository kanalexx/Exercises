package com.kanaa.mathan.matrix.sorting;

import com.kanaa.common.Logger;
import com.kanaa.measurement.TimeMeter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Замер времени выполнения алгоритмов сортировок
 *
 * @author Alexander Kanunnikov
 */

public class SortTimeMeasurement {
    private static final String resources = System.getProperty("user.dir")+"\\resources\\";
    /** Список файлов */
    private static final List<String> FILE_NAME_LIST = Arrays.asList(
            resources + "10.txt"
            , resources + "100.txt"
            , resources + "1000.txt"
            , resources + "10000.txt"
            //            , resources + "100000.txt"
            //            , resources + "1000000.txt"
    );
    /** Список сортировок */
    private static final List<Sorting> SORTING_LIST = Arrays.asList(
            Sorting.INSERTION
            ,Sorting.SELECTION
            ,Sorting.MERGE
    );
    //
    private static final Logger logger = new Logger();
    /** Выходной поток */
    private PrintStream writer;
    /** Список файлов с массивами */
    private List<String> fileNameList;
    /** Список сортировок */
    private List<Sorting> sortingList;
    /** Список массивов */
    private List<List<Integer>> dataList = new ArrayList<>(8);

    /**
     * Конструктор
     * @param writer        - выходной поток для фиксации времени выполнения
     * @param fileNameList  - список файлов с массивами различной длины (в каждом файле один массив)
     * @param sortingList   - список сортировок, подлежащих измерению
     */
    public SortTimeMeasurement(PrintStream writer, List<String> fileNameList, List<Sorting> sortingList) {
        this.writer = writer;
        this.fileNameList = fileNameList;
        this.sortingList = sortingList;
    }

    /**
     * Запуск измерения
     */
    public void run() throws IOException {
        logger.log("Замер скорости различных алгоритмов сортировки");
        initDataList();
        for (Sorting sorting : sortingList) {
            runSort(sorting.sortName(), sorting);
        }
        logger.log("Замер скорости завершен");
    }

    private void initDataList() throws IOException {
        logger.log("Инициализация массивов:");
        for (String fileName : fileNameList) {
            dataList.add(readListFromFile(fileName));
        }
        logger.log("Инициализация массивов завершена");
    }

    private List<Integer> readListFromFile(String fileName) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(fileName));
        List<Integer> list = new ArrayList<>();
        lines.forEach((value) -> list.add(Integer.parseInt(value)));
        logger.logf("Загружен файл %s", fileName);
        return list;
    }

    private void runSort(String caption, Sorter sorter) {
        writer.println(caption);
        TimeMeter timeMeter = new TimeMeter(writer);
        for (List<Integer> list : dataList) {
            timeMeter.writeDuration(String.valueOf(list.size()), () -> sorter.sort(list));
        }
    }

    public static void main(String[] args) {
        try {
            SortTimeMeasurement measurement = new SortTimeMeasurement(System.out, FILE_NAME_LIST, SORTING_LIST);
            measurement.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}