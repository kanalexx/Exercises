package com.kanaa.mathan.matrix.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Интерфейс сортировщика списков
 *
 * @author Alexander Kanunnikov
 */
public interface Sorter {

    /**
     * Сортирует указанный список
     */
    default <T extends Comparable<T>> void sort(List<T> list) {
        sort(list, Comparator.naturalOrder());
    }


    /**
     * Сортирует указанный список
     */
    <T extends Comparable<T>> void sort(List<T> list, Comparator<T> comparator);

    /**
     * Сортирует указанный список в обратном порядке
     */
    default <T extends Comparable<T>> void sortDesc(List<T> list) {
        sort(list, Comparator.reverseOrder());
    }
}
