package com.kanaa.mathan.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class ArrayTest {

    @Test
    public void indexOfMax() {
        Array<Integer> array = new Array<>(1, 2);
        assertEquals(1, array.indexOfMax());
        //
        array = new Array<>(2, 1);
        assertEquals(0, array.indexOfMax());
        //
        array = new Array<>(2, 3, 1);
        assertEquals(1, array.indexOfMax());
        //
        array = new Array<>(2, 4, 1, 3);
        assertEquals(1, array.indexOfMax());
    }

    @Test
    public void indexOfMin() {
        Array<Integer> array = new Array<>(1, 2);
        assertEquals(0, array.indexOfMin());
        //
        array = new Array<>(2, 1);
        assertEquals(1, array.indexOfMin());
        //
        array = new Array<>(2, 1, 3);
        assertEquals(1, array.indexOfMin());
        //
        array = new Array<>(5, 1, 4, 2, 3);
        assertEquals(1, array.indexOfMin());
    }
}