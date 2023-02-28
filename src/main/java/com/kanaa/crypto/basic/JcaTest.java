package com.kanaa.crypto.basic;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.*;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Примеры использования взяты из
 * <a href="https://javarush.ru/groups/posts/2277-java-cryptography-architecture--pervoe-znakomstvo">Ссылка</a>
 */
public class JcaTest {

    static final String TEXT = "secret!!secret!!secret!!secret!!";

    public static void main(String[] args) throws Exception {
//        testMessageDigest();
//        testSymmetricEncrypting();
//        testAsymmetricEncrypting();
//        testSignature();
        testKeyStore();
    }

    private static void testKeyStore() throws Exception {
//        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        char[] ksPassword = "123abc".toCharArray();
//        try (InputStream keyStoreData = new FileInputStream("keystore.ks")) {
//            keyStore.load(keyStoreData, ksPassword);
//        }
        keyStore.load(null, ksPassword);
    }

    private static void testSignature() throws Exception {
        System.out.println("Исходный текст:");
        System.out.println(TEXT);
        byte[] data = TEXT.getBytes(UTF_8);
        // prepare keys
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512, SecureRandom.getInstanceStrong());
        KeyPair keyPair = keyGen.generateKeyPair();
        // Sign with private key
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(keyPair.getPrivate());
        signature.update(data);
        byte[] sign = signature.sign();
        System.out.println("Подпись:");
        System.out.println(DatatypeConverter.printHexBinary(sign));
        // Verify with public key
        signature.initVerify(keyPair.getPublic());
        signature.update(data);
        boolean verify = signature.verify(sign);
        System.out.println("Результат проверки: " + verify);
        assert verify;
    }

    private static void testAsymmetricEncrypting() throws Exception {
        System.out.println("Исходный текст:");
        System.out.println(TEXT);
        byte[] original = TEXT.getBytes(UTF_8);
        System.out.println(DatatypeConverter.printHexBinary(original));
        // prepare Keys
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(1024);
        KeyPair keyPair = keyGen.generateKeyPair();
        // RSA Encrypt with public key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encrypted = cipher.doFinal(original);
        System.out.println("Зашифрованный текст:");
        System.out.println(DatatypeConverter.printHexBinary(encrypted));
        // RSA Decrypt with private key
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("Расшифрованный текст");
        System.out.println(DatatypeConverter.printHexBinary(decrypted));
        System.out.println(new String(decrypted, UTF_8));
        assert Arrays.equals(original, decrypted);
    }

    private static void testMessageDigest() {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        byte[] input = "Александр Канунников".getBytes(UTF_8);
        byte[] digest = messageDigest.digest(input);
        System.out.println(messageDigest.getProvider().getInfo());
        System.out.println(messageDigest.getProvider().getClass().getName());
        System.out.println(DatatypeConverter.printHexBinary(input));
        System.out.println(DatatypeConverter.printHexBinary("Aleksandr Kanunnikov".getBytes(UTF_8)));
        System.out.println(DatatypeConverter.printHexBinary(digest));

        byte[] salt = new byte[16];
        try {
            SecureRandom.getInstanceStrong().nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
        messageDigest.update(salt);
    }

    private static void testSymmetricEncrypting() throws Exception {
        System.out.println("Исходный текст:");
        System.out.println(TEXT);
        System.out.println(DatatypeConverter.printHexBinary(TEXT.getBytes(UTF_8)));
        testCipherAES_ECB();
        testCipherAES_CBC();
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
        byte[] encrypted = cipher.doFinal(TEXT.getBytes(UTF_8));
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
        byte[] original = TEXT.getBytes(UTF_8);
        byte[] encrypted = cipher.doFinal(original);
        System.out.println(DatatypeConverter.printHexBinary(encrypted));
        // Decrypting
        System.out.println("Расшифрованный с AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println(new String(decrypted, UTF_8));
        assert Arrays.equals(original, decrypted);
    }
}
