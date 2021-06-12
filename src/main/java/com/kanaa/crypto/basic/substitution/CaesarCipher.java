package com.kanaa.crypto.basic.substitution;

import com.kanaa.crypto.basic.alphabet.Alphabet;

/**
 * Шифр Цезаря
 * <br> Правило шифрования состоит в замене i-й буквы алфавита буквой с номером i+b, где b - это сдвиг алфавита:
 *  при b<0 влево и при b>0 вправо.
 * <br> можно рассматривать как частный случай аффинного шифра, когда a=1.
 * @author Alexander Kanunnikov
 */

public class CaesarCipher extends AffineCipher {

    public CaesarCipher(Alphabet alphabet, int key) {
        super(alphabet, 1, key);
    }

    @Override
    public String name() {
        return "Шифр Цезаря";
    }
}