package org.example;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Enter the array size");
                int numberOfDigits = scan.nextInt();
                if (numberOfDigits <= 0) {
                    throw new InputMismatchException("Input error. Size <= 0");
                }
                int sumDigits = parser(scan, numberOfDigits);
                printResult(sumDigits);
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() != null ? e.getMessage() : "");
                System.out.println("Couldn't parse a number. Please, try again");
            }
            scan.nextLine();
        }
        System.out.println(scan.nextInt());
        scan.close();
    }

    private static int parser(Scanner scan, int numberOfDigits) {
        int sum = 0;
        int[] array = new int[numberOfDigits];
        int colDigits = 0;
        try {
            for (int j = 0; j < numberOfDigits; j++) {
                array[j] = scan.nextInt();
                if (array[j] < 0) {
                    sum -= array[j];
                    colDigits++;
                }
            }
        } catch (Exception e) {
            throw new InputMismatchException();
        }
        return colDigits > 0 ? sum/colDigits : -1;
    }
    private static void printResult(int sumDigits) {
        System.out.println( sumDigits == -1 ? "There are no negative elements" : sumDigits);
    }

}