package com.kanaa.mathan.matrix.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Перечиление доступных алгоритмов сортировки
 *
 * @author Alexander Kanunnikov
 */
public enum Sorting implements Sorter {
    INSERTION("Сортировка вставкой", new InsertionSort()),
    SELECTION("Сортировка выбором", new SelectionSort()),
    MERGE("Сортировка слиянием", new MergeSort());

    private String sortName;
    private Sorter sorter;

    Sorting(String sortName, Sorter sorter) {
        this.sortName = sortName;
        this.sorter = sorter;
    }

    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        this.sorter.sort(list, comparator);
    }

    public String sortName() {
        return sortName;
    }
}
