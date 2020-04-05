package com.company.exbase.integer;

/**
 * @author Alexander Kanunnikov
 */
public class ExIntegerImpl implements ExInteger, Comparable<Integer> {

    private Integer value;

    public ExIntegerImpl(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

    public byte byteValue() {
        return value.byteValue();
    }

    public short shortValue() {
        return value.shortValue();
    }

    public int intValue() {
        return value.intValue();
    }

    public long longValue() {
        return value.longValue();
    }

    public float floatValue() {
        return value.floatValue();
    }

    public double doubleValue() {
        return value.doubleValue();
    }

    public static int hashCode(int value) {
        return Integer.hashCode(value);
    }

    public int compareTo(Integer anotherInteger) {
        return value.compareTo(anotherInteger);
    }
}