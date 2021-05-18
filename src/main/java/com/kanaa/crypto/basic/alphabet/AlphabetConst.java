package com.kanaa.crypto.basic.alphabet;

/**
 * @author Alexander Kanunnikov
 */

public class AlphabetConst {

    private static final String eng = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String rus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String digits = "0123456789";
    private static final String spec = ".,[]{}!?@#$%^&*()-_+\"<>|/\\";
    private static final String space = " ";

    public static final Alphabet GENERAL = new AlphabetImpl(space + eng + rus + digits + spec);
    public static final Alphabet RUS = new AlphabetImpl(space + rus);
    public static final Alphabet RUS_EXTEND = new AlphabetImpl(space + rus + digits + spec);
}