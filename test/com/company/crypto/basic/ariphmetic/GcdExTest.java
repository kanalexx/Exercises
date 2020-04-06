package com.company.crypto.basic.ariphmetic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class GcdExTest {

    @Test
    public void test() {
        GcdEx gcd = new GcdEx(7, 33);
        assertEquals(1, gcd.value());
        assertEquals(-14, gcd.x());
        assertEquals(3, gcd.y());
    }

    @Test
    public void test2() {
        GcdEx gcd = new GcdEx(99, 78);
        assertEquals(3, gcd.value());
        assertEquals(-11, gcd.x());
        assertEquals(14, gcd.y());
    }

}