package com.kanaa.mathan;

import com.kanaa.mathan.matrix.Matrix;

/**
 * @author Alexander Kanunnikov
 */

public class MathanTest {

    public static void main(String[] args) {
        Integer[][] array = {{222, 255, 450, 560},
                             {34,  56,  756, 78},
                             {111, 455, 644, 950}};
        System.out.println("Длина массива array: " + array[0].length);
        //
        System.out.println("Исходная матрица:");
        Matrix<Integer> matrix = new Matrix<>(array);
        matrix.print();
        //
        System.out.println("Колонка с индексом 1:");
        System.out.println(matrix.col(1));
        //
        System.out.println("Транспонированная матрица:");
        Matrix<Integer> transposed = matrix.transpose();
        transposed.print();
        //
        System.out.println("Седловые точки");
        System.out.println(matrix.saddlePoints());


    }

}