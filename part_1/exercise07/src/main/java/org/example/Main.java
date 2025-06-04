package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the path to the file:");
            String pathFile = scan.next();

            double[] array = readArrayFromFile(pathFile);
            printResult(array);
            writeMinMax(array);
        } catch (FileNotFoundException e) {
            System.err.println("Input error. File isn't exist");
        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) { // Общий случай (например, NoSuchElementException)
            System.err.println("Неизвестная ошибка: " + e.getMessage());
        }
    }

    private static double[] readArrayFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scan = new Scanner(file);
        while (!scan.hasNextInt()) {scan.next();}
        int length = scan.nextInt();
        if (length <= 0) {
            throw new InputMismatchException("Input error. Size <= 0");
        }
        double[] result = new double[length];
        try {
            int j = 0;
            while(scan.hasNext() && j < length) {
                if(!scan.hasNextDouble()) {
                    scan.next();
                } else {
                    result[j] = scan.nextDouble();
                    j++;
                }
            }
            if (j < length) {
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            throw new InputMismatchException("Input error. Insufficient number of elements");
        }
        return result;
    }

    private static void writeMinMax(double[] array) {
        double min = array[0];
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        try (FileWriter writer = new FileWriter("text/result.txt")) {
            writer.write(min + " " + max);
            System.out.println("Saving min and max values in file");
        } catch (IOException e) {
            System.err.println("Ошибка при записи: " + e.getMessage());
        }

    }

    private static void printResult(double[] result) {
        System.out.println(result.length);
        for (double element : result) System.out.print(element + " ");
        System.out.println(" ");
    }

}