package com.kanaa.mathan.matrix.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Alexander Kanunnikov
 */
public class SelectionSortTest {

    @Test
    public void sort() {
        List<Integer> list = Arrays.asList(5, 1, 4, 2, 3);
        Sorting.SELECTION.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }

    @Test
    public void sortDesc() {
        List<Integer> list = Arrays.asList(5, 1, 4, 2, 3);
        Sorting.SELECTION.sortDesc(list);
        assertEquals(Arrays.asList(5, 4, 3, 2, 1), list);
    }

    @Test
    public void sortPart() {
        List<Integer> list = Arrays.asList(5, 1, 4, 2, 3);
        Sorting.SELECTION.sort(list, 1, 3);
        assertEquals(Arrays.asList(5, 1, 2, 4, 3), list);
    }
}