package com.company.crypto.basic;

/**
 * Зашифрованный текст
 *
 * @author Alexander Kanunnikov
 */

public class EncryptedData {

    /** Исходный открытый текст */
    private final String plainText;

    /** Зашифровнный текст */
    private final String cipherText;

    /** Алгоритм шифрования */
    private final EncryptingMethod encryptingMethod;

    public EncryptedData(String plainText, EncryptingMethod encryptingMethod) {
        this.plainText = plainText;
        this.encryptingMethod = encryptingMethod;
        this.cipherText = encryptingMethod.encrypt(plainText);
    }

    /**
     * Зашифрованный текст
     */
    public String value() {
        return cipherText;
    }

    public String view() {
        return String.format("Алгоритм: %s\nСтрока: %s\nШифр: %s",
                encryptingMethod.name(),
                plainText,
                cipherText);
    }
}