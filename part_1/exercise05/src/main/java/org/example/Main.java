package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sumDigits = 0;
        while(sumDigits == 0) {
            try {
                System.out.println("Enter the array size");
                int numberOfDigits = scan.nextInt();
                if (numberOfDigits <= 0) {
                    throw new InputMismatchException("Input error. Size <= 0");
                }
                int[] array = parserNumbers(scan, numberOfDigits);
                for (int element : array) {
                    if (isIdenticalFirstAndLastDigits(element)) {sumDigits++;}
                }
                if(sumDigits == 0) {
                    throw new InputMismatchException("There are no such elements");
                } else {
                    int[] result = fillResultArray(sumDigits, array);
                    printResult(result);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() != null ? e.getMessage() : "");
                System.out.println("Couldn't parse a number. Please, try again");
            }
            scan.nextLine();
        }
        scan.close();
    }

    private static int[] parserNumbers(Scanner scan, int length) {
        int[] result = new int[length];
        try {
            int j = 0;
            while(j < result.length) {
                result[j] = scan.nextInt();
                j++;
            }
        } catch (Exception e) {
            throw new InputMismatchException();
        }
        return result;
    }

    private static int[] fillResultArray(int sumDigits, int[] array) {
        int[] returnResult = new int[sumDigits];
        int index = 0;
        for (int element : array) {
            if (isIdenticalFirstAndLastDigits(element)) {
                returnResult[index] = element;
                index++;
            }
        }
        return returnResult;
    }

    private static void printResult(int[] result) {
        for (int element : result) System.out.print(element + " ");
    }

    private static boolean isIdenticalFirstAndLastDigits(final int value){
        int first = value;
        int last = value % 10;
        while(first > 9) first /= 10;
        return first == last;
    }

}