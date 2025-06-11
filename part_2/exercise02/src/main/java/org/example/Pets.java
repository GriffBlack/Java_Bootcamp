package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Pets{
    private List<Animal> pets;
    private Scanner scanner;

    public Pets() {
        this.pets = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    void run() {
        pets = new ArrayList<>();
        System.out.println("Enter the number of pet: ");

        int numPets = readPositiveInt(scanner);
        for (int i = 0; i < numPets; i++) {
            try {
                String type = scanner.nextLine();
                if (type.trim().equalsIgnoreCase("cat") || type.trim().equalsIgnoreCase("dog")) {
                    String name = scanner.nextLine();
                    int age = readPositiveInt(scanner);
                    if(age <= 0) {
                        throw new IllegalArgumentException("Incorrect input. Age <= 0");
                    }
                    double weight = readPositiveDouble(scanner);
                    if (weight <= 0) {
                        throw new IllegalArgumentException("Incorrect input. Mass <= 0");
                    }
                    addPets(type, name, age, weight);
                } else {
                    System.out.println("Incorrect input. Unsupported pet type");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.nextLine();
                i--;
            }
        }
        for (Animal pet : pets) {
            System.out.println(pet);
        }
    }

    public void addPets(String type, String name, int age, double mass) {
        try {
            Animal pet = type.trim().equalsIgnoreCase("dog")
                    ? new Dog(name, age, mass)
                    : new Cat(name, age, mass);
            pets.add(pet);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int readPositiveInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again:");
            }
        }
    }

    private static double readPositiveDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again:");
            }
        }
    }

    public static void main(String[] args) {
        Pets pets = new Pets();
        pets.run();
    }
}