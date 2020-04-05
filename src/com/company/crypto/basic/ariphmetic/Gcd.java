package com.company.crypto.basic.ariphmetic;

/**
 * Наибольший общий делитель (НОД) (Greatest Common Divisor)
 *
 * <br> Используется алгоритм Эйлера
 *
 * @author Alexander Kanunnikov
 */

public class Gcd {

    public int apply(int int1, int int2) {
        int rest = int2 % int1;
        if (rest == 0) {
            return int1;
        } else {
            return apply(rest, int1);
        }
    }
}