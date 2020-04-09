package com.company.mathan.matrix;

import java.util.Arrays;
import java.util.List;

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

    public int indexOfMax() {
        int max = 0;
        for (int i = 1; i < value.size(); i++) {
            if (value.get(i).compareTo(value.get(max)) > 0) {
                max = i;
            }
        }
        return max;
    }

    public int indexOfMin() {
        int min = 0;
        for (int i = 1; i < value.size(); i++) {
            if (value.get(i).compareTo(value.get(min)) < 0) {
                min = i;
            }
        }
        return min;
    }
}