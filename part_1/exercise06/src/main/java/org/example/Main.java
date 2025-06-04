package org.example;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("Enter the array size");
                int numberOfDigits = scan.nextInt();

                if (numberOfDigits <= 0) {
                    throw new InputMismatchException("Input error. Size <= 0");
                }

                double[] array = parserNumbers(scan, numberOfDigits);
                double[] resultArray = sortArray(array);

                printResult(resultArray);
                break;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() != null ? e.getMessage() : "");
                System.out.println("Couldn't parse a number. Please, try again");
            }
            scan.nextLine();
        }
        scan.close();
    }

    private static double[] parserNumbers(Scanner scan, int length) {
        double[] result = new double[length];
        try {
            int j = 0;
            while(j < result.length) {
                result[j] = scan.nextDouble();
                j++;
            }
        } catch (Exception e) {
            throw new InputMismatchException();
        }
        return result;
    }

    private static double[] sortArray(double[] array) {
        double[] resultArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            double min = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            resultArray[i] = min;
        }
        return resultArray;
    }

    private static void printResult(double[] result) {
        for (double element : result) System.out.print(element + " ");
    }

}