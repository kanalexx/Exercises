package com.company.crypto.basic.ariphmetic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class GcdTest {

    @Test
    public void apply() {
        Gcd gcd = new Gcd();
        assertEquals(17, gcd.apply(119, 544));
        assertEquals(1, gcd.apply(7, 33));
    }
}