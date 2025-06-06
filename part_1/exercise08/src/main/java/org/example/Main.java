package org.example;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter numbers:");
            if (scan.hasNextInt()) {
                int previos = scan.nextInt();
                int index = 0;
                while(scan.hasNextInt()) {
                    int next = scan.nextInt();
                    if (previos <= next) {
                        index++;
                        previos = next;
                    } else
                    {
                        throw new InputMismatchException(
                                "The sequence is not ordered from the ordinal number of the number " + ++index
                        );
                    }
                }
                System.out.println("The sequence is ordered in ascending order");
            }
            else {
                throw new InputMismatchException("Input error");
            }

        } catch (InputMismatchException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) { // Общий случай (например, NoSuchElementException)
            System.err.println("Неизвестная ошибка: " + e.getMessage());
        }
    }
}