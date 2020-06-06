package com.kanaa.mathan.matrix.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class MergeSortTest {

    @Test
    public void sort() {
        List<Integer> list = Arrays.asList(5, 1, 4, 2, 3);
        Sorting.MERGE.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }

    @Test
    public void sortDesc() {
        List<Integer> list = Arrays.asList(5, 1, 4, 2, 3);
        Sorting.MERGE.sortDesc(list);
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), list);
    }
}