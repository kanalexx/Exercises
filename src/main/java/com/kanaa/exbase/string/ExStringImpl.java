package com.kanaa.exbase.string;

/**
 * @author Alexander Kanunnikov
 */
public class ExStringImpl implements ExString {

    private String value;

    public ExStringImpl() {
        this("");
    }

    public ExStringImpl(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

}