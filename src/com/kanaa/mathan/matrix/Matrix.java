package com.kanaa.mathan.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Alexander Kanunnikov
 */

public class Matrix<T extends Number & Comparable<T>> {

    private List<List<T>> value;
    private final int rowCount;
    private final int colCount;

    public Matrix(final T[][] value) {
        this.value = new ArrayList<>(value.length);
        for (T[] row : value) {
            this.value.add(Arrays.asList(row));
        }
        rowCount = this.value.size();
        colCount = this.value.get(0).size();
    }

    public Matrix(List<List<T>> value) {
        this.value = value;
        rowCount = value.size();
        colCount = value.get(0).size();
    }


    public T value(int row, int col) {
        return value.get(row).get(col);
    }

    public void print() {
        print(System.out::print, ", ", "\n");
    }

    public void print(Consumer<String> printFunc, String delimiter, String lineDelimiter) {
        for (List<T> row : value) {
            for (T element : row) {
                printFunc.accept(element.toString() + delimiter);
            }
            printFunc.accept(lineDelimiter);
        }
    }

    public List<T> row(int index) {
        return value.get(index);
    }

    public List<T> col(int index) {
        List<T> col = new ArrayList<>(rowCount);
        for (int i = 0; i < rowCount; i++) {
            col.add(value(i, index));
        }
        return col;
    }

    public Matrix<T> transpose() {
        List<List<T>> transposed = new ArrayList<>(colCount);
        for (int i = 0; i < colCount; i++) {
            transposed.add(col(i));
        }
        return new Matrix<>(transposed);
    }

    public Collection<T> saddlePoints() {
        Matrix<T> transposed = this.transpose();
        ArrayList<T> result = new ArrayList<>(Math.min(rowCount, colCount));
        for (List<T> row : value) {
            int minInRow = (new Array<>(row)).indexOfMin();
            List<T> col = transposed.row(minInRow);
            int maxInCol = (new Array<>(col)).indexOfMax();
            if (row.get(minInRow).equals(col.get(maxInCol))) {
                result.add(value(minInRow, maxInCol));
            }
        }
        return result;
    }

}