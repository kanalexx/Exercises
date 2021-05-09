package com.kanaa.crypto.basic.cryptanalysis;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Alexander Kanunnikov
 */
public class DecryptingTextTest {

    @Test
    public void replace() {
        DecryptingText decryptingText = new DecryptingText("АДБФВЫФРЫ", "");
        decryptingText.replace("Ф", "Д");
        decryptingText.print();
        assertEquals("***Д**Д**",decryptingText.decryptedText());
    }
}