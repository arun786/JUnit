package com.arun;

/**
 * This class calculates the factorial of a number
 */
public class Factorial {
    public int factorial(int number) {
        if (number == 0) return 1;
        return number * factorial(number - 1);
    }
}
