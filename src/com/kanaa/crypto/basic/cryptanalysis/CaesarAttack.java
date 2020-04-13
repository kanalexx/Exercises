package com.kanaa.crypto.basic.cryptanalysis;

import com.kanaa.crypto.basic.EncryptingMethod;
import com.kanaa.crypto.basic.alphabet.Alphabet;
import com.kanaa.crypto.basic.alphabet.AlphabetCp1251;
import com.kanaa.crypto.basic.alphabet.AlphabetImpl;
import com.kanaa.crypto.basic.substitution.CaesarCipher;

import java.util.Map;
import java.util.TreeMap;

/**
 * Вскрытие шифра Цезаря
 * <br> Требуется информация об алфавите (странице кодировки) зашифрованного текста
 * @author Alexander Kanunnikov
 */

public class CaesarAttack {

    private String cipherText;

    private Alphabet alphabet;

    public CaesarAttack(String cipherText, Alphabet alphabet) {
        this.cipherText = cipherText;
        this.alphabet = alphabet;
    }

    /**
     * Перебор ключей
     */
    public Map<Integer, String> bruteForce(int alphabetSize) {
        Map<Integer, String> result = new TreeMap<>();
        for (int i = 1; i < alphabetSize; i++) {
            EncryptingMethod cipher = new CaesarCipher(alphabet, i);
            result.put(i, cipher.decrypt(cipherText));
        }
        return result;
    }

    /**
     * Тест атаки на шифр Цезаря полным перебором ключей
     * @param args - [0] - зашифрованный текст
     *             - [1] - строка алфавита
     */
    public static void main(String[] args) {
        final String PLAIN_TEXT = "Канунников Александр 1988 г.р.";
        Map<Integer, String> variants;
        String cipherText;
        if (args.length == 0) {
            Alphabet alphabet = new AlphabetCp1251();
            cipherText = (new CaesarCipher(alphabet, 7)).encrypt(PLAIN_TEXT);
            variants = (new CaesarAttack(cipherText, alphabet).bruteForce(33));
        } else {
            cipherText = args[0];
            Alphabet alphabet = args.length >= 2 ? new AlphabetImpl(args[1]) : new AlphabetCp1251();
            variants = (new CaesarAttack(cipherText, alphabet).bruteForce(33));
        }
        //
        System.out.println("Зашифрованный текст:\n"+cipherText);
        System.out.println("Варианты перебора:");
        for (Map.Entry<Integer, String> variant : variants.entrySet()) {
            System.out.printf("Ключ:%s; Значение: %s\n", variant.getKey(), variant.getValue());
        }
    }
}