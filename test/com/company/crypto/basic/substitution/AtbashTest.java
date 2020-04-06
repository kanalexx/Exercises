package com.company.crypto.basic.substitution;

import com.company.crypto.basic.TestConst;
import com.company.crypto.basic.alphabet.Alphabet;
import com.company.crypto.basic.alphabet.AlphabetImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtbashTest {

    private Alphabet alphabet = new AlphabetImpl(TestConst.RUS_SMALL_SYMBOLS);

    /**
     * Корректоность шифрования
     */
    @Test
    public void testEncrypt() {
        AffineCipher cipher = new Atbash(alphabet);
        assertEquals("яюэьыъщшчцхфутсрпонмлкйизжёедгвба", cipher.encrypt(TestConst.RUS_SMALL_SYMBOLS));
    }

    /**
     * Корректоность расшифровки
     */
    @Test
    public void testDecrypt() {
        AffineCipher cipher = new Atbash(alphabet);
        assertEquals(TestConst.RUS_SMALL_SYMBOLS, cipher.decrypt("яюэьыъщшчцхфутсрпонмлкйизжёедгвба"));
    }

}