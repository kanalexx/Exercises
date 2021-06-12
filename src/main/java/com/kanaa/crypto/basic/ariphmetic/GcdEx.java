package com.kanaa.crypto.basic.ariphmetic;

/**
 * Наибольший общий делитель (НОД)(Greatest Common Divisor) целых чисел
 * <br> С использованием расширенного алгоритма Эйлера, который, кроме самого значения НОД, дает возможность узнать
 * коэффициенты в уравнении: a*x + b*y = gcd
 *
 * @author Alexander Kanunnikov
 */

public final class GcdEx {

    private int a;

    private int b;

    private int x;

    private int y;

    /** Значение НОД */
    private int value;

    public GcdEx(int a, int b) {
        this.a = a;
        this.b = b;
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
        return Math.abs(value);
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    /**
     * "a" и "b" взаимно простые числа если их НОД равен 1.
     */
    public boolean coprime() {
        return value() == 1;
    }

    /**
     * Число, обратное числу "a" по модулю "b"
     * a*x=1 (mod b)
     * <br> Оно существует только для взаимно простых чисел
     */
    public int inverse_a() {
        if (coprime()) {
            return (x % b + b) % b;
        } else {
            throw new IllegalArgumentException(String.format(
                "Число, обратное числу \"a\" по модулю \"b\" не существует" +
                " т.к. \"a\"(%s) и \"b\"(%s) не являются взаимно простыми числами",
                a, b));
        }
    }
}