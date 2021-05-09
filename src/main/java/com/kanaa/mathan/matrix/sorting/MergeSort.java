package com.kanaa.mathan.matrix.sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Сортировка слиянием
 *
 * @author Alexander Kanunnikov
 */

public class MergeSort implements Sorter {

    @Override
    public <T> void sort(List<T> list, int lo, int hi, Comparator<T> comparator) {
        doMergeSort(list, lo, hi, comparator);
    }

    /**
     * Рекурсивно: делит входящий список на две части и выполняет сортировку каждой, затем слияние
     * @param list        - входящий список
     * @param p           - индекс левой границы списка
     * @param r           - индекс правой границы списка
     */
    protected <T> void doMergeSort(List<T> list, int p, int r, Comparator<T> comparator) {
        // если длина части больше одного элемента
        if (p < r) {
            // индекс середины списка
            int q = (p + r) / 2;
            // сортировка левой части
            doMergeSort(list, p, q, comparator);
            // сортировка правой части
            doMergeSort(list, q + 1, r, comparator);
            // слияние со сравнением
            doMerge(list, p, q, r, comparator);
        }
    }

    /**
     * Делит входящий список на два массива: левый (от p по q) и правый (от q+1 по r)
     * и делает попарные сравнения элементов из двух массивов
     * @param list        - входящий список элементов
     * @param p           - индекс левой границы списка
     * @param q           - индекс середины списка
     * @param r           - индекс правой границы списка
     */
    protected <T> void doMerge(List<T> list, int p, int q, int r, Comparator<T> comparator) {
        // количество элементов в левом массиве
        int lSize = q - p + 1;
        // количество элементов в правом массиве
        int rSize = r - q;
        // объявление левого массива
        T[] lArr = (T[]) new Object[lSize];
        // объявление правого массива
        T[] rArr = (T[]) new Object[rSize];
        // заполнение левого массива левой частью списка
        for (int i = 0; i < lSize; i++) {
            lArr[i] = list.get(p + i);
        }
        // заполниние правого массива правой частью массива
        for (int j = 0; j < rSize; j++) {
            rArr[j] = list.get(q + j + 1);
        }
        // индекс левого массива
        int i = 0;
        // индекс правого массива
        int j = 0;
        // попарно сравниваются элементы из левого и правого массивов, и наименьший записывается в список на позицию k
        for (int k = p; k <= r; k++) {
            // если правый индекс достиг предела, то сразу берется левый элемент,
            // иначе сравниваются, но при условии что левый индекс тоже не достиг предела,
            // иначе бертся правый элемент
            if (j == rSize || (i != lSize && comparator.compare(lArr[i], rArr[j]) <= 0)) {
                list.set(k, lArr[i]);
                i++;
            } else {
                list.set(k, rArr[j]);
                j++;
            }
        }
    }
}