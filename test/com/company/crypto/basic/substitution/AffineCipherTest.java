package com.company.crypto.basic.substitution;

import com.company.crypto.basic.TestConst;
import com.company.crypto.basic.alphabet.Alphabet;
import com.company.crypto.basic.alphabet.AlphabetConst;
import com.company.crypto.basic.alphabet.AlphabetImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

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
        Assert.assertEquals("елтщажнфывипцэдксшяёмуъбзохьгйрчю", cipher.encrypt(TestConst.RUS_SMALL_SYMBOLS));
    }

    /**
     * Корректоность расшифровки
     */
    @Test
    public void testDecrypt() {
        AffineCipher cipher = new AffineCipher(alphabet,7,5);
        Assert.assertEquals(TestConst.RUS_SMALL_SYMBOLS, cipher.decrypt("елтщажнфывипцэдксшяёмуъбзохьгйрчю"));
    }

    /**
     * Неправильно подобранный ключ шифра
     */
    @Test
    public void testIllegalKey() {
        try {
            AffineCipher cipher = new AffineCipher(alphabet,9,5);
            Assert.fail("Ожидается исключение IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            Assert.assertNotEquals("", e.getMessage());
        }
    }
}