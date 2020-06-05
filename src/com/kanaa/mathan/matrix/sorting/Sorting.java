package com.kanaa.mathan.matrix.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Перечиление доступных алгоритмов сортировки
 *
 * @author Alexander Kanunnikov
 */
public enum Sorting implements Sorter {
    INSERTION(new InsertionSort());

    private Sorter sorter;

    Sorting(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public <T extends Comparable<T>> void sort(List<T> list, Comparator<T> comparator) {
        this.sorter.sort(list, comparator);
    }
}
