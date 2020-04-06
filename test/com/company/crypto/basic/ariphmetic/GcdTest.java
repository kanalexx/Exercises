package com.company.crypto.basic.ariphmetic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class GcdTest {

    @Test
    public void apply() {
        assertEquals(17, (new Gcd(119, 544)).value());
        assertEquals(1, (new Gcd(7, 33)).value());
        assertEquals(33, (new Gcd(33, 0)).value());
        assertEquals(33, (new Gcd(0, 33)).value());
    }
}