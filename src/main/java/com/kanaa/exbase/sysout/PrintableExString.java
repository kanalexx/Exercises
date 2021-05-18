package com.kanaa.exbase.sysout;

import com.kanaa.exbase.string.ExString;

public class PrintableExString implements ExString {

    private ExString exString;

    public PrintableExString() {
        this("");
    }

    public PrintableExString(String value) {
        this.exString = ExString.create(value);
    }

    public PrintableExString(ExString value) {
        this.exString = value;
    }

    @Override
    public String value() {
        return exString.value();
    }

    public void print() {
        System.out.println(value());
    }
}