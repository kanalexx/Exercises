package com.company.crypto.basic.alphabet;

/**
 * Алфавит, содержащий страницу кодировки Unicode.
 * @author Alexander Kanunnikov
 */

public class AlphabetUnicode implements Alphabet {

    @Override
    public int index(String symbol) {
          return symbol.charAt(0);
    }

    @Override
    public String symbol(int index) {
        return String.valueOf((char) index);
    }

    @Override
    public int size() {
        return 65536;
    }
}