package com.kanaa.mathan.matrix.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Сортировка выбором
 *
 * Сначала определяется наименьший элемент массива А, который ставится на место элемента А[1].
 * Затем производится поиск второго наименьшего элемента массива А, который ставится на место элемента А[2].
 * Этот процесс продолжается для первых n-1 элементов массива А.
 *
 * @author Alexander Kanunnikov
 */

public class SelectionSort implements Sorter {

    @Override
    public <T> void sort(List<T> list, int lo, int hi, Comparator<T> comparator) {
        if (list.isEmpty())
            return;
        for (int i = lo; i < hi; i++) {
            // ищется индекс минимального элемента
            int indOfMin = i;
            for (int j = i + 1; j <= hi; j++) {
                if (comparator.compare(list.get(indOfMin), list.get(j)) > 0) {
                    indOfMin = j;
                }
            }
            // если текущий элемент не является минимальным, то они меняются местами
            if (i != indOfMin) {
                T tmp = list.get(indOfMin);
                list.set(indOfMin, list.get(i));
                list.set(i, tmp);
            }
        }
    }
}