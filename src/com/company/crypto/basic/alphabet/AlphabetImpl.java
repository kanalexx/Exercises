package com.company.crypto.basic.alphabet;

/**
 * Алфавит с произвольным набором символов
 *
 * @author Alexander Kanunnikov
 */
public class AlphabetImpl implements Alphabet {

    private String symbols;

    public AlphabetImpl(String symbols) {
        this.symbols = symbols;
    }

    @Override
    public int index(String symbol) {
        int index = symbols.indexOf(symbol);
        if (index < 0) {
            throw new IllegalArgumentException(String.format("Символ \"%s\" отсутствует в алфавите.", symbol));
        }
        return index;
    }

    @Override
    public String symbol(int index) {
        if (index >= 0 && index < this.size()) {
            return String.valueOf(symbols.charAt(index));
        } if (index >= this.size()) {
            // зацикленность алфавита
            int idx = index % this.size();
            return String.valueOf(symbols.charAt(idx));
        } else {
            throw new IllegalArgumentException(String.format("Недопустимый индекс (%s).", index));
        }
    }

    @Override
    public int size() {
        return symbols.length();
    }
}