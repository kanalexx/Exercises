package com.kanaa.crossword;

import com.kanaa.mathan.matrix.Matrix;

import java.util.List;

/**
 * Кроссворд
 *
 * Что такое "Кроссворд"? Кроссворд - это список клеток (ячеек), которые имеют определенное положение и назначение.
 * Структура Кроссворда задается матрицей чисел: 0 - черная клетка и 1 - белая клетка.
 *
 * @author Alexander Kanunnikov
 */

public class Crossword {

    private List<Cell> cells;

    public Crossword(Matrix<Integer> skeleton) {

    }

    public List<Cell> cells() {
        return cells;
    }
}