package com.kanaa.mathan.matrix.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Сортировка слиянием со вставкой
 *
 * @author Alexander Kanunnikov
 */

public class MergeInsertSort extends MergeSort implements Sorter {

    /** Предел длины массива для сортировки вставкой */
    private static final int LENGTH_FOR_INSERTION = 7;

    /**
     * Рекурсивно: делит входящий список на две части и выполняет сортировку каждой, затем слияние
     * @param list        - входящий список
     * @param p           - индекс левой границы списка
     * @param r           - индекс правой границы списка
     */
     protected <T> void doMergeSort(List<T> list, int p, int r, Comparator<T> comparator) {
        // если длина части достаточно мала для сортировки вставкой
        if ((r - p) <= LENGTH_FOR_INSERTION) {
            Sorting.INSERTION.sort(list, p, r, comparator);
        } else {
            super.doMergeSort(list, p, r, comparator);
        }
    }
}