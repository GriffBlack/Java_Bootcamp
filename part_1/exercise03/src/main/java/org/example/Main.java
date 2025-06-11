package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final int MAX_LONG_FIB = 92;
    private static long[] cache;

    public static void main(String[] args) {
        try {
            int number = inputNumber();
            cache = new long[number + 1];
            if (number > MAX_LONG_FIB) {
                throw new ArithmeticException();
            }
            long outNumber = recursiveFibonacci(number);
            printResult(outNumber);
        } catch (ArithmeticException e) {
            System.out.println("Fibonacci number is too large for long type");
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
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return getNumber;
    }

    private static long recursiveFibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (cache[n] != 0) return cache[n]; // Используем кеш

        long result = recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);

        // Проверка на переполнение
        if (result < 0) {
            throw new ArithmeticException("Fibonacci(" + n + ") overflows long");
        }

        cache[n] = result; // Сохраняем в кеш
        return result;
    }

    private static void printResult(long result) {
        System.out.println("Fibonacci number: " + result);
    }
}