package com.company.crypto.basic.ariphmetic;

/**
 * Наибольший общий делитель (НОД)(Greatest Common Divisor) целых чисел
 * <br> Используется обычный алгоритм Эйлера
 *
 * @author Alexander Kanunnikov
 */

public class Gcd {

    private int value;

    public Gcd(int a, int b) {
        if (b == 0) {
            value = a;
        } else {
            value = (new Gcd(b, a % b)).value();
        }
    }

    public int value() {
        return value;
    }

}