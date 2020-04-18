package com.kanaa.crypto.basic.cryptanalysis;

import com.kanaa.common.Logger;

/**
 * @author Alexander Kanunnikov
 */

public class DecryptingText {

    private static final Logger LOGGER = new Logger();

    private final String cipherText;

    private String decryptedText;

    public DecryptingText(String cipherText, String decryptedText) {
        this.cipherText = cipherText;
        if (decryptedText == null || decryptedText.length() == 0) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() < cipherText.length()) {
                sb.append("*");
            }
            this.decryptedText = sb.toString();
        } else {
            this.decryptedText = decryptedText;
        }
    }

    public void print() {
        LOGGER.printf("%s\n%s", cipherText, decryptedText);
    }

    public void replace(String cipherSubStr, String openSubStr) {
        int index = -1;
        do {
            index = cipherText.indexOf(cipherSubStr, index+1);
            if (index >= 0) {
                decryptedText = decryptedText.substring(0, index) + openSubStr + decryptedText.substring(index+openSubStr.length());
            }
        } while (index != -1);
    }

    public String decryptedText() {
        return decryptedText;
    }
}