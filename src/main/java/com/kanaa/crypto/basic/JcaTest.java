package com.kanaa.crypto.basic;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class JcaTest {

    static final String TEXT = "secret!!secret!!secret!!secret!!";

    private static void testMessageDigest() {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] input = "Александр Канунников".getBytes(StandardCharsets.UTF_8);
        byte[] digest = messageDigest.digest(input);
        System.out.println(messageDigest.getProvider().getInfo());
        System.out.println(messageDigest.getProvider().getClass().getName());
        System.out.println(DatatypeConverter.printHexBinary(input));
        System.out.println(DatatypeConverter.printHexBinary("Aleksandr Kanunnikov".getBytes(StandardCharsets.UTF_8)));
        System.out.println(DatatypeConverter.printHexBinary(digest));

        byte[] salt = new byte[16];
        try {
            SecureRandom.getInstanceStrong().nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        messageDigest.update(salt);
    }

    private static void testCipherAES_ECB() throws Exception {
        // Generate new key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        Key key = keyGen.generateKey();
        // Encrypt with key
        String transformation = "AES/ECB/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        System.out.println("Закодированный с AES/ECB/PKCS5Padding");
        byte[] encrypted = cipher.doFinal(TEXT.getBytes(StandardCharsets.UTF_8));
        System.out.println(DatatypeConverter.printHexBinary(encrypted));
    }

    private static void testCipherAES_CBC() throws Exception {
        // Initialization Vector
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] rnd = new byte[16];
        random.nextBytes(rnd);
        IvParameterSpec ivSpec = new IvParameterSpec(rnd);
        // Prepare key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        Key key = keyGen.generateKey();
        // CBC
        String transformation = "AES/CBC/PKCS5Padding";
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
        // Encrypting
        System.out.println("Закодированный с AES/CBC/PKCS5Padding");
        byte[] original = TEXT.getBytes(StandardCharsets.UTF_8);
        byte[] encrypted = cipher.doFinal(original);
        System.out.println(DatatypeConverter.printHexBinary(encrypted));
        // Decrypting
        System.out.println("Расшифрованный с AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println(new String(decrypted, StandardCharsets.UTF_8));
        assert Arrays.equals(original, decrypted);
    }

    public static void main(String[] args) throws Exception {
//        testMessageDigest();
        System.out.println("Исходный текст:");
        System.out.println(TEXT);
        System.out.println(DatatypeConverter.printHexBinary(TEXT.getBytes(StandardCharsets.UTF_8)));
        testCipherAES_ECB();
        testCipherAES_CBC();
    }
}
