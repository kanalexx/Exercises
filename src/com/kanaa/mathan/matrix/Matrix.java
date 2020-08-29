package com.kanaa.mathan.matrix;

import com.sun.xml.internal.ws.commons.xmlutil.Converter;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Alexander Kanunnikov
 */

public class Matrix<T extends Number & Comparable<T>> {

    private List<List<T>> value;

    public Matrix(final T[][] value) {
        this.value = new ArrayList<>(value.length);
        for (T[] row : value) {
            this.value.add(Arrays.asList(row));
        }
    }

    public Matrix(List<List<T>> value) {
        this.value = value;
    }

    public Matrix(File file, Function<String, T> converter) throws IOException {
        this.value = new ArrayList<>();
        try ( BufferedReader reader = new BufferedReader(new FileReader(file))) {
            reader.lines().forEach(line -> {
                String[] row = line.split(" ");
                List<T> rowList = new ArrayList<>(row.length);
                for (String item : row) {
                    rowList.add(converter.apply(item));
                }
                this.value.add(rowList);
            });
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Matrix<?> matrix = (Matrix<?>) o;
        return value.equals(matrix.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        value.forEach(sb::append);
        return sb.toString();
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
        List<T> col = new ArrayList<>(rowCount());
        for (int i = 0; i < rowCount(); i++) {
            col.add(value(i, index));
        }
        return col;
    }

    public Matrix<T> transpose() {
        List<List<T>> transposed = new ArrayList<>(colCount());
        for (int i = 0; i < colCount(); i++) {
            transposed.add(col(i));
        }
        return new Matrix<>(transposed);
    }

    public Collection<T> saddlePoints() {
        Matrix<T> transposed = this.transpose();
        ArrayList<T> result = new ArrayList<>(Math.min(rowCount(), colCount()));
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

    public int rowCount() {
        return value.size();
    }

    public int colCount() {
        return !value.isEmpty() ? value.get(0).size() : 0;
    }

}