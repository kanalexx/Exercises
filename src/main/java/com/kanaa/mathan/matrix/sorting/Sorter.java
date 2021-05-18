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
    default <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, 0, list.size() - 1, Comparator.naturalOrder());
    }


    /**
     * Сортирует часть указанного списка
     */
    <T> void sort(List<T> list, int lo, int hi, Comparator<T> comparator);

    /**
     * Сортирует часть указанного списка
     */
    default <T extends Comparable<? super T>> void sort(List<T> list, int lo, int hi) {
        sort(list, lo, hi, Comparator.naturalOrder());
    }

    /**
     * Сортирует указанный список в обратном порядке
     */
    default <T extends Comparable<? super T>> void sortDesc(List<T> list) {
        sort(list, 0, list.size() - 1, Comparator.reverseOrder());
    }
}
