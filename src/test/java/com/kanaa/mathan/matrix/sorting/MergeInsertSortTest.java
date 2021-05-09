package com.kanaa.mathan.matrix.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class MergeInsertSortTest {

    @Test
    public void sort() {
        List<Integer> list = Arrays.asList(
                54, 43, 27, 96, 4, 21, 87, 73, 49, 9, 28, 14, 34, 4, 23, 36, 81, 35, 11, 78, 41, 73, 0, 54, 31, 15, 21, 89, 75, 82, 26, 23, 85, 83, 85, 38, 56, 91, 30, 56, 59, 61, 57, 79, 95, 5, 42, 21, 89, 83, 0, 75, 74, 73, 46, 59, 77, 51, 26, 97, 8, 71, 46, 30, 82, 3, 4, 4, 53, 5, 57, 44, 92, 90, 24, 6, 41, 96, 28, 87, 7, 93, 54, 2, 66, 37, 48, 51, 31, 28, 45, 45, 48, 47, 86, 25, 44, 26, 57, 70
        );
        Sorting.MERGEINSERT.sort(list);
        assertEquals(Arrays.asList(
                0, 0, 2, 3, 4, 4, 4, 4, 5, 5, 6, 7, 8, 9, 11, 14, 15, 21, 21, 21, 23, 23, 24, 25, 26, 26, 26, 27, 28, 28, 28, 30, 30, 31, 31, 34, 35, 36, 37, 38, 41, 41, 42, 43, 44, 44, 45, 45, 46, 46, 47, 48, 48, 49, 51, 51, 53, 54, 54, 54, 56, 56, 57, 57, 57, 59, 59, 61, 66, 70, 71, 73, 73, 73, 74, 75, 75, 77, 78, 79, 81, 82, 82, 83, 83, 85, 85, 86, 87, 87, 89, 89, 90, 91, 92, 93, 95, 96, 96, 97
        ), list);
    }
}