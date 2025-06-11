package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Enter the number of Strings:");
                List<User> users = new ArrayList<User>();

                if (scan.hasNextInt()) {
                    int count = scan.nextInt();
                    while (count != 0) {
                        try {
                            String name = scan.next();
                            if (!scan.hasNextInt()) {
                                System.out.println("Couldn't parse a number. Please, try again.");
                                continue;
                            }
                            int age = scan.nextInt();

                            users.add(new User(name, age));
                            count--;

                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getMessage());

                        }
                    }
                    printAnswer(users);
                break;
                } else {
                    scan.nextLine();
                    throw new InputMismatchException("Couldn't parse a number. Please, try again");
                }

            } catch (InputMismatchException e) {
                System.err.println(e.getMessage());

            } catch (Exception e) { // Общий случай (например, NoSuchElementException)
                System.err.println("Неизвестная ошибка: " + e.getMessage());
            }
        }
    }

    private static void printAnswer(List<User> users) {
        String  stringNamed = users.stream()
                .filter(user -> user.getAge() >= 18)
                .map(User::getName)
                .collect(Collectors.joining(", "));
        System.out.println(stringNamed);
    }
}