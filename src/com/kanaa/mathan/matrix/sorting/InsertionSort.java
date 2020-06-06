package com.kanaa.mathan.matrix.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Сортировка вставкой
 *
 * @author Alexander Kanunnikov
 */

public class InsertionSort implements Sorter {

    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        if (list.isEmpty())
            return;
        for (int j = 1; j < list.size(); j++) {
            T key = list.get(j);
            int i = j - 1;
            while (i >= 0 && comparator.compare(list.get(i), key) > 0) {
                list.set(i + 1, list.get(i));
                i--;
            }
            list.set(i + 1, key);
        }
    }

}