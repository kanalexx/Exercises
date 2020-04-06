package com.company.crypto.basic.ariphmetic;

/**
 * Проверка, что два целых числа являются взаимно простыми
 *
 * <br> целые числа взаимно просты, если их наибольший общий делитель (НОД) равен 1.
 *
 * @author Alexander Kanunnikov
 */
public class Coprime {

    public boolean apply(int firsInt, int secondInt) {
        return Math.abs((new Gcd(firsInt, secondInt)).value()) == 1;
    }
}