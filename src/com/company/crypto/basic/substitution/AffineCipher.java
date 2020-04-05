package com.company.crypto.basic.substitution;

import com.company.crypto.basic.alphabet.Alphabet;
import com.company.crypto.basic.ariphmetic.Coprime;

/**
 * Аффинный шифр
 *
 * <br> Функция шифрования: E(x) = (a*x + b) mod m
 * <br> Функция дешифрования: D(x) = pow(a,-1)(x - b) mod m
 * <br> где m - размер алфавита; пара a и b — ключ шифра.
 * <br> Значение a должно быть выбрано таким, что a и m — взаимно простые числа.
 *
 * @author Alexander Kanunnikov
 */

public class AffineCipher extends SimpleSubstitutionCipher {

    private int key_a;

    private int key_b;

    public AffineCipher(Alphabet alphabet, int a, int b) {
        super(alphabet);
        this.key_a = a;
        this.key_b = b;
        checkKeyA();
    }

    /**
     * Ключ "а" должен быть взаимно простым с рзмером алфавита
     */
    private void checkKeyA() {
        boolean isCoprime = (new Coprime()).apply(key_a, alphabet.size());
        if (!isCoprime) {
            throw new IllegalArgumentException("Неверно подобран ключ шифра: ключ \"a\" и размер алфавита должны быть взаимно простыми");
        }
    }

    @Override
    protected String cipherSymbol(String plainSymbol) {
        int plainIndex = alphabet.index(plainSymbol);
        int cipherIndex = (key_a * plainIndex + key_b) % alphabet.size();
        return alphabet.symbol(cipherIndex);
    }

    @Override
    protected String plainSymbol(String cipherSymbol) {
        return "";
    }

}