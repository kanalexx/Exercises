package com.company.crypto.basic;

import com.company.crypto.basic.alphabet.Alphabet;
import com.company.crypto.basic.alphabet.AlphabetCp1251;
import com.company.crypto.basic.alphabet.AlphabetUnicode;

import java.io.IOException;

/**
 * @author Alexander Kanunnikov
 */

public class CryptoTest {

    private static void printBuf(byte[] buf) {
        for (byte b : buf) {
            System.out.print(String.valueOf((int) b) +",");
        }
        System.out.println("");
    }

    public static void main(String[] args) throws IOException {
        Alphabet alphabetUnicode = new AlphabetUnicode();
        Alphabet alphabetCp1251 = new AlphabetCp1251();
        String symbol = "ф";
        System.out.println(String.format("Код символа \"%s\" в UTF8: %s", symbol, alphabetUnicode.index(symbol)));
        System.out.println(String.format("Код символа \"%s\" в Cp1251: %s", symbol, alphabetCp1251.index(symbol)));
        String encoded = new String(symbol.getBytes(), "utf8");
        printBuf(symbol.getBytes("Cp1251"));
        printBuf(encoded.getBytes("utf8"));
        System.out.println(alphabetCp1251.symbol(65530));
//        String cipherText = (new EncryptedData(
//                "абра кадабра",
//        )).value();
//        System.out.println();
    }

}