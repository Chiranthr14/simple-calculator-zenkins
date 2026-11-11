package com.calculator;

public class calculator {
    public int add(int a, int b) { 
        return a + b; 
    }
    public int subtract(int a, int b) { 
        return a - b; 
    }

    public static void main(String[] args) {
        calculator calc = new calculator();
        System.out.println("--- Simple Calculator Execution ---");
        System.out.println("Addition (5 + 3): " + calc.add(5, 3));
        System.out.println("Subtraction (5 - 3): " + calc.subtract(5, 3));
    }
}
