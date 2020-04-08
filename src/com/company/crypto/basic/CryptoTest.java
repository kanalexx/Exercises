package com.company.crypto.basic;

import com.company.crypto.basic.alphabet.*;
import com.company.crypto.basic.substitution.AffineCipher;
import com.company.crypto.basic.substitution.Atbash;
import com.company.crypto.basic.substitution.CaesarCipher;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Alexander Kanunnikov
 */

public class CryptoTest {

    private static void printBuf(byte[] buf) {
        for (byte b : buf) {
            System.out.print(String.valueOf(b) +",");
        }
        System.out.println();
    }

    private static final String PLAIN_TEXT = "Канунников Александр 1988 г.р.";

    public static void main(String[] args) throws IOException {
        Alphabet alphabetUnicode = new AlphabetUnicode();
        Alphabet alphabetCp1251 = new AlphabetCp1251();
        String symbol = "ф";
        System.out.println(String.format("Код символа \"%s\" в UTF8: %s", symbol, alphabetUnicode.index(symbol)));
        System.out.println(String.format("Код символа \"%s\" в Cp1251: %s", symbol, alphabetCp1251.index(symbol)));
        String encoded = new String(symbol.getBytes(), StandardCharsets.UTF_8);
        printBuf(symbol.getBytes("Cp1251"));
        printBuf(encoded.getBytes(StandardCharsets.UTF_8));
        System.out.println(alphabetCp1251.symbol(65530));
        //
        Alphabet alphabet = AlphabetConst.RUS_EXTEND;
        // Аффинный шифр
        System.out.println();
        EncryptedData affineEncrypted = new EncryptedData(PLAIN_TEXT, new AffineCipher(alphabet, 13, 26));
        System.out.println(affineEncrypted.view());
        // Атбаш
        System.out.println();
        EncryptedData atbashEncrypted = new EncryptedData(PLAIN_TEXT, new Atbash(alphabet));
        System.out.println(atbashEncrypted.view());
        // Шифр Цезаря
        System.out.println();
        EncryptedData caesarEncrypted = new EncryptedData(PLAIN_TEXT, new CaesarCipher(alphabet, 7));
        System.out.println(caesarEncrypted.view());
    }

}