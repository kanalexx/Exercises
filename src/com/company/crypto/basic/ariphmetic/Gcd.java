package com.company.crypto.basic.ariphmetic;

/**
 * Наибольший общий делитель (НОД)(Greatest Common Divisor) целых чисел
 * <br> Используется обычный алгоритм Эйлера
 *
 * @author Alexander Kanunnikov
 */

public final class Gcd {

    private int value;

    public Gcd(int a, int b) {
        if (b == 0) {
            value = a;
        } else {
            value = (new Gcd(b, a % b)).value();
        }
    }

    public int value() {
        return Math.abs(value);
    }

    /**
     * "a" и "b" взаимно простые числа если их НОД равен 1.
     */
    public boolean coprime() {
        return value() == 1;
    }
}