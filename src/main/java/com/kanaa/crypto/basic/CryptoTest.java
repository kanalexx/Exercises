package com.kanaa.crypto.basic;

import com.kanaa.crypto.basic.alphabet.*;
import com.kanaa.crypto.basic.substitution.AffineCipher;
import com.kanaa.crypto.basic.substitution.Atbash;
import com.kanaa.crypto.basic.substitution.CaesarCipher;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Alexander Kanunnikov
 */

public class CryptoTest {

    private static void printBuf(byte[] buf) {
        for (byte b : buf) {
            System.out.printf("%X ", b);
        }
        System.out.println();
    }

    private static void printHex(byte[] buf) {
        int lenStr = 0;
        for (byte b : buf) {
            System.out.printf("%X ", b);
            if (++lenStr > 15) {
                lenStr = 0;
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void printInt(byte[] buf) {
        int lenStr = 0;
        int idx = 0;
        while (idx < buf.length) {
            int i = (idx < buf.length ? (buf[idx++] << 24) & 0xFF000000 : 0) |
                    (idx < buf.length ? (buf[idx++] << 16) & 0x00FF0000 : 0) |
                    (idx < buf.length ? (buf[idx++] << 8) & 0x0000FF00 : 0)  |
                    (idx < buf.length ? (buf[idx++] << 0) & 0x000000FF : 0);
            System.out.printf("%X ", i);
            if (++lenStr > 3) {
                lenStr = 0;
                System.out.println();
            }
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
        // Вывод в HEX
        System.out.println();
        System.out.println("Вывод в HEX:");
        String testStr = "Это тестовый буфер для проверки порядка следования байтов";
        System.out.println(testStr);
        byte[] buf = testStr.getBytes("Cp1251");
        printHex(buf);
        System.out.println("PrintInt:");
        printInt(buf);
    }

}