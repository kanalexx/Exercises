package com.kanaa.crypto.basic;

/**
 * Метод шифрования (алгоритм)
 *
 * @author Alexander Kanunnikov
 */
public interface EncryptingMethod {

    /**
     * Наименование алгоритма шифрования
     */
    String name();

    /**
     * Зашифровать исходные данные
     */
    String encrypt(String data);

    /**
     * Расшифровать зашифрованный текст
     */
    String decrypt(String data);

}
