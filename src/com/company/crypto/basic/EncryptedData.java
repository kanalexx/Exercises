package com.company.crypto.basic;

/**
 * Зашифрованный текст
 *
 * @author Alexander Kanunnikov
 */

public class EncryptedData {

    /** Исходный открытый текст */
    private final String plainText;

    /** Алгоритм шифрования */
    private final EncryptingMethod encryptingMethod;

    public EncryptedData(String plainText, EncryptingMethod encryptingMethod) {
        this.plainText = plainText;
        this.encryptingMethod = encryptingMethod;
    }

    /**
     * Зашифрованный текст
     */
    public String value() {
        return encryptingMethod.encrypt(plainText);
    }
}