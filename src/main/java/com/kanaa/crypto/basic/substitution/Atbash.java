package com.kanaa.crypto.basic.substitution;

import com.kanaa.crypto.basic.alphabet.Alphabet;

/**
 * Шифр Атбаш
 * <br> Правило шифрования состоит в замене i-й буквы алфавита буквой с номером m-i+1, где m - число букв в алфавите.
 * <br> можно рассматривать как частный случай аффинного шифра, когда a=b=m-1.
 */
public class Atbash extends AffineCipher {

    public Atbash(Alphabet alphabet) {
        super(alphabet, alphabet.size() - 1, alphabet.size() - 1);
    }

    @Override
    public String name() {
        return "Атбаш";
    }
}
