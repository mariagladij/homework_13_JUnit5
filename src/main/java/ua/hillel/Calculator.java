package ua.hillel;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) {
        if (b!=0)
            return a / b;
        else throw new ArithmeticException();
    }

    public int multiply(int a, int b) {
        return a * b;
    }


}

