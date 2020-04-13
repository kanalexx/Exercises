package com.kanaa.crypto.basic.alphabet;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class AlphabetUnicodeTest {

    private Alphabet alphabet = new AlphabetUnicode();

    /**
     * Индекс какого-либо символа больше нуля
     */
    @Test
    public void testIndex() {
        assertTrue(alphabet.index("f") > 0);
    }

    /**
     * Символ по какому-либо индексу не равен пустой строке
     */
    @Test
    public void testSymbol() {
        assertNotEquals("", alphabet.symbol(22));
    }

    /**
     * Взаимосоответсвие методов index() и symbol()
     */
    @Test
    public void testSymbolByIndex() {
        String symbol = "f";
        int idx = alphabet.index("f");
        assertEquals(symbol, alphabet.symbol(idx));
    }

    @Test
    public void testIndexBySymbol() {
        int idx = 92;
        String symbol = alphabet.symbol(idx);
        assertEquals(idx, alphabet.index(symbol));
    }

    /**
     * Размер
     */
    @Test
    public void testSize() {
        // Размер непустого алфавита больше нуля
        assertTrue(alphabet.size() > 0);
    }

    /**
     * Кирилица
     */
    @Test
    public void testRusSymbol() {
        // Код русского символа "ф" равен 1092
        assertEquals(1092, alphabet.index("ф"));
        // сивол с кодом 1092 равен "ф"
        assertEquals("ф", alphabet.symbol(1092));
    }
}