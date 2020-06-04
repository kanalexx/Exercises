package com.kanaa.mathan.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
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
     * Сортировка вставкой (по возрастанию)
     */
    public void insertionSort() {
        insertionSort((T val1, T val2) -> val1.compareTo(val2) > 0);
    }

    /**
     * Сортировка вставкой (по убыванию)
     */
    public void insertionSortDesc() {
        insertionSort((T val1, T val2) -> val1.compareTo(val2) < 0);
    }

    /**
     * Сортировка вставкой
     */
    private void insertionSort(BiFunction<T, T, Boolean> compare) {
        int size = value.size();
        for (int j = 1; j < size; j++) {
            T key = value.get(j);
            int i = j - 1;
            while (i >= 0 && compare.apply(value.get(i), key)) {
                value.set(i + 1, value.get(i));
                i--;
            }
            value.set(i + 1, key);
        }
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