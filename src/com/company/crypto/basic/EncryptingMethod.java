package com.company.crypto.basic;

/**
 * Метод шифрования (алгоритм)
 *
 * @author Alexander Kanunnikov
 */
public interface EncryptingMethod {

    /**
     * Зашифровать исходные данные
     */
    String encrypt(String data);

    /**
     * Расшифровать зашифрованный текст
     */
    String decrypt(String data);

}
