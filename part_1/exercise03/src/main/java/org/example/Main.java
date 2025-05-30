package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = inputNumber();
        try {
            int outNumber = recursiveFibonacci(number);
            printResult(outNumber);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int inputNumber() {
        System.out.print("Enter Fibonacci index (n >= 0): ");
        Scanner scanner = new Scanner(System.in);
        int getNumber = 0;
        while (true) {
            try {
                getNumber = scanner.nextInt();
                if (getNumber >= 0) {
                    break;
                } else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                scanner.nextLine();
            }
        }
        return getNumber;
    }
    private static int recursiveFibonacci(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        try {
            int result = Math.addExact(recursiveFibonacci(number - 1), recursiveFibonacci(number - 2));
            return result;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Fibonacci number is too large for long type");
        }
    }

    private static void printResult(long result) {
        System.out.println("Fibonacci number: " + result);
    }
}