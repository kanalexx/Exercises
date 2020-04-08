package com.company.crypto.basic.substitution;

import com.company.crypto.basic.TestConst;
import com.company.crypto.basic.alphabet.Alphabet;
import com.company.crypto.basic.alphabet.AlphabetImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class CaesarCipherTest {

    private Alphabet alphabet = new AlphabetImpl(TestConst.RUS_SMALL_SYMBOLS);

    @Test
    public void encrypt() {
        CaesarCipher caesarCipher = new CaesarCipher(alphabet, 7);
        assertEquals("жзийклмнопрстуфхцчшщъыьэюяабвгдеё", caesarCipher.encrypt(TestConst.RUS_SMALL_SYMBOLS));
    }

    @Test
    public void encrypt2() {
        CaesarCipher caesarCipher = new CaesarCipher(alphabet, -7);
        assertEquals("щъыьэюяабвгдеёжзийклмнопрстуфхцчш", caesarCipher.encrypt(TestConst.RUS_SMALL_SYMBOLS));
    }

    @Test
    public void decrypt() {
        CaesarCipher caesarCipher = new CaesarCipher(alphabet, 7);
        assertEquals(TestConst.RUS_SMALL_SYMBOLS, caesarCipher.decrypt("жзийклмнопрстуфхцчшщъыьэюяабвгдеё"));
    }

    @Test
    public void decrypt2() {
        CaesarCipher caesarCipher = new CaesarCipher(alphabet, -7);
        assertEquals(TestConst.RUS_SMALL_SYMBOLS, caesarCipher.decrypt("щъыьэюяабвгдеёжзийклмнопрстуфхцчш"));
    }

}