package com.kanaa.crypto.basic.ariphmetic;

import org.junit.Assert;
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
        assertEquals(19, gcd.inverse_a());
    }

    @Test
    public void test2() {
        GcdEx gcd = new GcdEx(99, 78);
        assertEquals(3, gcd.value());
        assertEquals(-11, gcd.x());
        assertEquals(14, gcd.y());
        try {
            gcd.inverse_a();
            Assert.fail("Ожидается исключение IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }

}