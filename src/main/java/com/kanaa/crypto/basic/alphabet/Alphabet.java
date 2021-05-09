package com.kanaa.crypto.basic.alphabet;

/**
 * Алфавит
 * @author Alexander Kanunnikov
 */
public interface Alphabet {

    /**
     * Получить индекс указанного символа
     */
    int index(String symbol);

    /**
     * Получить символ по указанному индексу
     */
    String symbol(int index);

    /**
     * Размер алфавита
     */
    int size();

}
