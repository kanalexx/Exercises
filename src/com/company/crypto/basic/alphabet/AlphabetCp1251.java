package com.company.crypto.basic.alphabet;

import java.io.UnsupportedEncodingException;

/**
 * Алфавит, содержащий страницу кодировки Win-1251 (Cp1251)
 * @author Alexander Kanunnikov
 */

public class AlphabetCp1251 implements Alphabet {

    public static final String charsetName = "Cp1251";

    @Override
    public int index(String symbol) {
        try {
            byte[] bytes = symbol.getBytes(charsetName);
            return bytes[0] & 0xFF;
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Неизвестная кодировка");
        }
    }

    @Override
    public String symbol(int index) {
        try {
            return (new String(new byte[] {Integer.valueOf(index).byteValue()}, charsetName));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Неизвестная кодировка");
        }
    }

    @Override
    public int size() {
        return 256;
    }
}