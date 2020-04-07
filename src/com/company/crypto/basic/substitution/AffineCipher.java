package com.company.crypto.basic.substitution;

import com.company.crypto.basic.alphabet.Alphabet;
import com.company.crypto.basic.ariphmetic.GcdEx;

/**
 * Аффинный шифр
 *
 * <br> Функция шифрования: E(x) = (a*x + b) mod m
 * <br> Функция дешифрования: D(x) = inverse_a*(x + m - b) mod m
 * <br> где m - размер алфавита; пара a и b — ключ шифра.
 * <br> Значение a должно быть выбрано таким, что a и m — взаимно простые числа.
 * <br> В дешифровании pow(a,-1) - это число обратное числу а по модулю m.
 * @author Alexander Kanunnikov
 */

public class AffineCipher extends SimpleSubstitutionCipher {

    private int key_a;

    private int key_b;

    private int inverse_a;

    public AffineCipher(Alphabet alphabet, int a, int b) {
        super(alphabet);
        this.key_a = a;
        this.key_b = b;
        //
        GcdEx gcd = new GcdEx(a, alphabet.size());
        if (!gcd.coprime()) {
            throw new IllegalArgumentException("Неверно подобран ключ шифра: ключ \"a\" и размер алфавита должны быть взаимно простыми");
        }
        inverse_a = gcd.inverse_a();
    }

    @Override
    public String name() {
        return "Аффинный шифр";
    }

    @Override
    protected String cipherSymbol(String plainSymbol) {
        int plainIndex = alphabet.index(plainSymbol);
        int cipherIndex = (key_a * plainIndex + key_b) % alphabet.size();
        return alphabet.symbol(cipherIndex);
    }

    @Override
    protected String plainSymbol(String cipherSymbol) {
        // D(x) = inverse_a*(x + m - b) mod m
        int plainIndex = (inverse_a * (alphabet.index(cipherSymbol) + alphabet.size() - key_b)) % alphabet.size();
        return alphabet.symbol(plainIndex);
    }

}