package com.company.exbase.integer;

import com.company.exbase.ExBase;

/**
 * @author Alexander Kanunnikov
 */
interface ExInteger extends ExBase<Integer> {

    static ExInteger create(Integer value) {
        return new ExIntegerImpl(value);
    }

    static String toString(int i, int radix) {
        return Integer.toString(i, radix);
    }

    static String toUnsignedString(int i, int radix) {
        return Integer.toUnsignedString(i, radix);
    }

    static String toHexString(int i) {
        return Integer.toHexString(i);
    }

    static String toOctalString(int i) {
        return Integer.toOctalString(i);
    }

    static String toBinaryString(int i) {
        return Integer.toBinaryString(i);
    }

    static String toString(int i) {
        return Integer.toString(i);
    }

    static String toUnsignedString(int i) {
        return Integer.toUnsignedString(i);
    }

    static int parseInt(String s, int radix) throws NumberFormatException {
        return Integer.parseInt(s, radix);
    }

    static int parseInt(String s) throws NumberFormatException {
        return Integer.parseInt(s);
    }

    static int parseUnsignedInt(String s, int radix) throws NumberFormatException {
        return Integer.parseUnsignedInt(s, radix);
    }

    static int parseUnsignedInt(String s) throws NumberFormatException {
        return Integer.parseUnsignedInt(s);
    }

    static Integer valueOf(String s, int radix) throws NumberFormatException {
        return Integer.valueOf(s, radix);
    }

    static Integer valueOf(String s) throws NumberFormatException {
        return Integer.valueOf(s);
    }

    static Integer valueOf(int i) {
        return Integer.valueOf(i);
    }

    static Integer getInteger(String nm) {
        return Integer.getInteger(nm);
    }

    static Integer getInteger(String nm, int val) {
        return Integer.getInteger(nm, val);
    }

    static Integer getInteger(String nm, Integer val) {
        return Integer.getInteger(nm, val);
    }

    static Integer decode(String nm) throws NumberFormatException {
        return Integer.decode(nm);
    }

    static int compare(int x, int y) {
        return Integer.compare(x, y);
    }

    static int compareUnsigned(int x, int y) {
        return Integer.compareUnsigned(x, y);
    }

    static long toUnsignedLong(int x) {
        return Integer.toUnsignedLong(x);
    }

    static int divideUnsigned(int dividend, int divisor) {
        return Integer.divideUnsigned(dividend, divisor);
    }

    static int remainderUnsigned(int dividend, int divisor) {
        return Integer.remainderUnsigned(dividend, divisor);
    }

    static int highestOneBit(int i) {
        return Integer.highestOneBit(i);
    }

    static int lowestOneBit(int i) {
        return Integer.lowestOneBit(i);
    }

    static int numberOfLeadingZeros(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    static int numberOfTrailingZeros(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    static int bitCount(int i) {
        return Integer.bitCount(i);
    }

    static int rotateLeft(int i, int distance) {
        return Integer.rotateLeft(i, distance);
    }

    static int rotateRight(int i, int distance) {
        return Integer.rotateRight(i, distance);
    }

    static int reverse(int i) {
        return Integer.reverse(i);
    }

    static int signum(int i) {
        return Integer.signum(i);
    }

    static int reverseBytes(int i) {
        return Integer.reverseBytes(i);
    }

    static int sum(int a, int b) {
        return Integer.sum(a, b);
    }

    static int max(int a, int b) {
        return Integer.max(a, b);
    }

    static int min(int a, int b) {
        return Integer.min(a, b);
    }
}