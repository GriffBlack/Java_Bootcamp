package org.example;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter seconds: ");
        int seconds = 0;
        seconds = inputSeconds();
        String outTime = "";
        outTime = getTime(seconds);
        printTime(outTime);
    }

    private static int inputSeconds() {
        Scanner scanner = new Scanner(System.in);
        int numSecond = 0;
        while (true) {
            try {
                numSecond = scanner.nextInt();
                if (numSecond >= 0) {
                    break;
                } else {
                    System.out.println("Incorrect time");
                }

            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
                scanner.nextLine();
            }
        }
        return numSecond;
    }
    private static String getTime(int numSecond) {
        LocalTime time = LocalTime.MIDNIGHT.plusSeconds(numSecond);
        return String.format("%02d:%02d:%02d", time.getHour(), time.getMinute(), time.getSecond());
    }
    private static void printTime(String outTime) {
        System.out.println(outTime);
    }
}