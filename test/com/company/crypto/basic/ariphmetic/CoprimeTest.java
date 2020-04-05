package com.company.crypto.basic.ariphmetic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class CoprimeTest {

    @Test
    public void apply() {
        Coprime coprime = new Coprime();
        assertFalse(coprime.apply(9, 33));
        assertTrue(coprime.apply(7, 33));
        assertTrue(coprime.apply(-7, -33));
        assertTrue(coprime.apply(7, -33));
    }
}