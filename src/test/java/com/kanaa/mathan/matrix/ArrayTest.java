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

    @Test
    public void indexOfExpression() {
        Array<Integer> array = new Array<>(1, 3, 4, 2, 3);
        // индекс элемента, который больше 2 равен 1
        assertEquals(1, array.indexOf(value -> value.compareTo(2) > 0));
    }

    @Test
    public void equalsTest() {
        Array<Integer> array1 = new Array<>(5, 1, 4, 2, 3);
        Array<Integer> array2 = new Array<>(5, 1, 4, 2, 3);
        Array<Integer> array3 = new Array<>(3, 2, 4, 1, 5);
        assertEquals(array1, array2);
        assertNotEquals(array1, array3);
    }

    @Test
    public void cloneTest() {
        Array<Integer> array1 = new Array<>(5, 1, 4, 2, 3);
        Array<Integer> array2 = array1.clone();
        assertEquals(array1, array2);
        assertNotSame(array1, array2);
    }

    @Test
    public void swap() {
        Integer[] array = {5, 1, 4, 2, 3};
        Array<Integer> arrayObj = new Array<>(array);
        arrayObj.swap(1, 3);
        // массив изменился
        assertArrayEquals(new Integer[]{5, 2, 4, 1, 3}, array);
    }
}