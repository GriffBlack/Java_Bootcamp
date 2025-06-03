package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private int numberOfDigits = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter muss number");
        while(true) {
            try {
                int numberOfDigits = scan.nextInt();
                printResult(numberOfDigits);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Couldn't parse a number. Please, try again");
            }
            parser(args);
        }
    }
    private static int parser(String[] args) {

    }
    private static void printResult(int numberOfDigits) {
        System.out.println(numberOfDigits);
    }

    public void setNumberOfDigits(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public int getNumberOfDigits() {
        return numberOfDigits;
    }
}