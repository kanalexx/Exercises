package com.company.crypto.basic.substitution;

import com.company.crypto.basic.TestConst;
import com.company.crypto.basic.alphabet.Alphabet;
import com.company.crypto.basic.alphabet.AlphabetImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class AffineCipherTest {

    private Alphabet alphabet = new AlphabetImpl(TestConst.RUS_SMALL_SYMBOLS);

    @Before
    public void setUp() throws Exception {
    }

    /**
     * Корректоность шифрования
     */
    @Test
    public void testEncrypt() {
        AffineCipher cipher = new AffineCipher(alphabet,7,5);
        assertEquals("елтщажнфывипцэдксшяёмуъбзохьгйрчю", cipher.encrypt(TestConst.RUS_SMALL_SYMBOLS));
    }

    /**
     * Корректоность расшифровки
     */
    @Test
    public void testDecrypt() {
        AffineCipher cipher = new AffineCipher(alphabet,7,5);
        assertEquals(TestConst.RUS_SMALL_SYMBOLS, cipher.decrypt("елтщажнфывипцэдксшяёмуъбзохьгйрчю"));
    }

    /**
     * Неправильно подобранный ключ шифра
     */
    @Test
    public void testIllegalKey() {
        try {
            AffineCipher cipher = new AffineCipher(alphabet,9,5);
            fail("Ожидается исключение IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertNotEquals("", e.getMessage());
        }
    }
}