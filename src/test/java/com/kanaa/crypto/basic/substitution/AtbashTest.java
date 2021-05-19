package com.kanaa.crypto.basic.substitution;

import com.kanaa.crypto.basic.TestConst;
import com.kanaa.crypto.basic.alphabet.Alphabet;
import com.kanaa.crypto.basic.alphabet.AlphabetImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtbashTest {

    private Alphabet alphabet = new AlphabetImpl(TestConst.RUS_SMALL_SYMBOLS);

    /**
     * Корректность шифрования
     */
    @Test
    public void testEncrypt() {
        AffineCipher cipher = new Atbash(alphabet);
        assertEquals("яюэьыъщшчцхфутсрпонмлкйизжёедгвба", cipher.encrypt(TestConst.RUS_SMALL_SYMBOLS));
    }

    /**
     * Корректность расшифровки
     */
    @Test
    public void testDecrypt() {
        AffineCipher cipher = new Atbash(alphabet);
        assertEquals(TestConst.RUS_SMALL_SYMBOLS, cipher.decrypt("яюэьыъщшчцхфутсрпонмлкйизжёедгвба"));
    }

}