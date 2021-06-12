package com.kanaa.crypto.basic.alphabet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class AlphabetImplTest {

    private Alphabet alphabet;
    private final static Alphabet EMPTY_ALPHABET = new AlphabetImpl("");

    @Before
    public void setUp() throws Exception {
        alphabet = new AlphabetImpl("abcf");
    }

    @Test
    public void testIndex() {
        assertEquals(1, alphabet.index("b"));
    }

    @Test
    public void testSymbol() {
        assertEquals("b", alphabet.symbol(1));
    }

    /**
     * Тест символа, который не содержится в алфавите.
     * В пустом алфавите любой символ будет неправильный.
     * Ожидается исключение IllegalArgumentException.
     */
    @Test
    public void testWrongSymbol() {
        try {
            EMPTY_ALPHABET.index("a");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            assertNotEquals("", e.getMessage());
        }
    }

    /**
     * Тест индекса, который больше размера алфавита.
     * Алфавит зациклен.
     */
    @Test
    public void testIndexOverSize() {
        assertEquals("b", alphabet.symbol(13));
    }

    /**
     * Тест отрицательного индекса.
     * Зацикленность алфавита обеспечивает сдвиг алфавита влево.
     */
    @Test
    public void testNegativeIndex() {
        assertEquals("b", alphabet.symbol(-3));
    }

    /**
     * Взаимное соответствие методов index() и symbol()
     */
    @Test
    public void testSymbolByIndex() {
        String symbol = "f";
        int idx = alphabet.index("f");
        assertEquals(symbol, alphabet.symbol(idx));
    }

    @Test
    public void testIndexBySymbol() {
        int idx = 3;
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
        // Точный размер алфавита
        assertEquals(4, (new AlphabetImpl("1234")).size());
        // Размер пустого алфавита равен нулю
        assertEquals(0, EMPTY_ALPHABET.size());
    }
}