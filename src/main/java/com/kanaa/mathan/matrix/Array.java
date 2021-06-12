package com.kanaa.mathan.matrix;

import com.kanaa.mathan.matrix.sorting.Sorter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 *
 * @author Alexander Kanunnikov
 */

public class Array<T extends Comparable<T>> {

    private final List<T> value;

    public Array(T ...value) {
        this.value = Arrays.asList(value);
    }

    public Array(List<T> value) {
        this.value = value;
    }

    /**
     * Возвращает индекс элемента с максимальным значением
     */
    public int indexOfMax() {
        int max = 0;
        for (int i = 1; i < value.size(); i++) {
            if (value.get(i).compareTo(value.get(max)) > 0) {
                max = i;
            }
        }
        return max;
    }

    /**
     * Возвращает индекс элемента с минимальным значением
     */
    public int indexOfMin() {
        int min = 0;
        for (int i = 1; i < value.size(); i++) {
            if (value.get(i).compareTo(value.get(min)) < 0) {
                min = i;
            }
        }
        return min;
    }

    /**
     * Линейный поиск элемента, удовлетворяющий условию expression
     * @return индекс элемента, и -1 если элемент не найден
     */
    public int indexOf(Predicate<T> expression) {
        for (int ind = 0; ind < value.size(); ind++) {
            if (expression.test(value.get(ind))) {
                return ind;
            }
        }
        return -1;
    }

    /**
     * Перестановка двух элементов массива
     */
    public void swap(int i, int j) {
        value.set(i, value.set(j, value.get(i)));
    }

    /**
     * Сортирует элементы указанным алгоритмом сортировки
     */
    public void sort(Sorter sorter) {
        sorter.sort(value);
    }

    /**
     * Сортирует элементы указанным алгоритмом сортировки (по убыванию)
     */
    public void sortDesc(Sorter sorter) {
        sorter.sortDesc(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Array<T> clone() {
        return new Array<T>((T[]) value.toArray());
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj instanceof Array) {
            Array<T> other = (Array<T>) obj;
            return value.equals(other.value);
        } else {
            return false;
        }
    }
}