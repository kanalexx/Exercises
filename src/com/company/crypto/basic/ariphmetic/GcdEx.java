package com.company.crypto.basic.ariphmetic;

/**
 * Наибольший общий делитель (НОД)(Greatest Common Divisor) целых чисел
 * <br> С использованием расширенного алгоритма Эйлера, который, кроме сомого значения НОД, дает возможность узнать
 * коэфисиенты в уравнении: a*x + b*y = gcd
 *
 * @author Alexander Kanunnikov
 */

public class GcdEx {

    private int x;

    private int y;

    /** Значение НОД */
    private int value;

    public GcdEx(int a, int b) {
        if (b == 0) {
            x = 1;
            y = 0;
            value = a;
        } else {
            GcdEx gcd = new GcdEx(b, a % b);
            x = gcd.y();
            y = gcd.x() - (a / b) * gcd.y();
            value = gcd.value();
        }
    }

    public int value() {
        return value;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}