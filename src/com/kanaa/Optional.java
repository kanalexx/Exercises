package com.kanaa;

public class Optional<T> {
    private T value;

    public Optional() {
    }

    public Optional(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value == null)
            return null;
        return this.value.getClass().getName() + " " + this.value;
    }
}