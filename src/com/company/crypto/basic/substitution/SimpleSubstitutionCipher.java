package com.company.crypto.basic.substitution;

import com.company.crypto.basic.EncryptingMethod;
import com.company.crypto.basic.alphabet.Alphabet;

/**
 * Шифр простой замены (подстановки)
 *
 * <br> В шифрах простой замены замена производится только над одним-единственным символом.
 *
 * @author Alexander Kanunnikov
 */

public abstract class SimpleSubstitutionCipher implements EncryptingMethod {

    /**
     * Алфавит, к которому принадлежит открытый текст
     */
    protected Alphabet alphabet;

    public SimpleSubstitutionCipher(Alphabet alphabet) {
        this.alphabet = alphabet;
    }

    /**
     * Замена символа из открытого текста на символ из зашифрованного алфавита
     */
    protected abstract String cipherSymbol(String plainSymbol);

    /**
     * Замена зашифроанного символа на символ из открытого текста
     */
    protected abstract String plainSymbol(String cipherSymbol);

    @Override
    public String encrypt(String data) {
        StringBuilder encrypted = new StringBuilder();
        for (int i=0; i<data.length(); i++) {
            encrypted.append(cipherSymbol(data.substring(i, i+1)));
        }
        return encrypted.toString();
    }

    @Override
    public String decrypt(String data) {
        StringBuilder decrypted = new StringBuilder();
        for (int i=0; i<data.length(); i++) {
            decrypted.append(plainSymbol(data.substring(i, i+1)));
        }
        return decrypted.toString();
    }
}