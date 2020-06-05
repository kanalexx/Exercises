package com.kanaa.mathan.matrix.sorting;

import java.util.Comparator;
import java.util.List;

/**
 *
 * Сортировка вставкой
 *
 * @author Alexander Kanunnikov
 */

public class InsertionSort implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(List<T> value, Comparator<T> comparator) {
        int size = value.size();
        for (int j = 1; j < size; j++) {
            T key = value.get(j);
            int i = j - 1;
            while (i >= 0 && comparator.compare(value.get(i), key) > 0) {
                value.set(i + 1, value.get(i));
                i--;
            }
            value.set(i + 1, key);
        }
    }

}