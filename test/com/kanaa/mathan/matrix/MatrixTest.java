package com.kanaa.mathan.matrix;

import com.kanaa.Resources;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class MatrixTest {

    @Test
    public void common() {
        Matrix<Integer> matrix = new Matrix<>(new Integer[][] {{0,1},{1,0},{1,2}});
        //
        assertEquals(3, matrix.rowCount());
        assertEquals(2, matrix.colCount());
        assertEquals(Arrays.asList(1, 0), matrix.row(1));
        assertEquals(Arrays.asList(1, 0, 2), matrix.col(1));
    }

    @Test
    public void readFromFile() throws IOException {
        Matrix<Integer> matrixFromFile = new Matrix<>(Resources.file("testMatrix.txt"), Integer::valueOf);
        Matrix<Integer> matrix = new Matrix<>(new Integer[][] {{0,1},{1,0},{1,2}});
        assertEquals(matrix, matrixFromFile);
    }
}