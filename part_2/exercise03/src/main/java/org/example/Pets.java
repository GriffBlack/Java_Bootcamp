package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Pets {
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
                if (!type.equals("dog") && !type.equals("cat") &&
                        !type.equals("hamster") && !type.equals("guinea")) {
                    System.out.println("Incorrect input. Unsupported pet type");
                    continue;
                }
                String name = scanner.nextLine();
                int age = readPositiveInt(scanner);
                if (age <= 0) {
                    throw new IllegalArgumentException("Incorrect input. Age <= 0");
                }
                Animal pet = switch (type) {
                    case "dog" -> new Dog(name, age);
                    case "cat" -> new Cat(name, age);
                    case "hamster" -> new Hamster(name, age);
                    case "guinea" -> new GuineaPig(name, age);
                    default -> throw new IllegalArgumentException("Unsupported pet type");
                };
                pets.add(pet);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.nextLine();
                i--;
            }
        }
        pets.stream()
                .filter(pet -> pet instanceof Herbivore)
                .forEach(System.out::println);
        pets.stream()
                .filter(pet -> pet instanceof Omnivore)
                .forEach(System.out::println);
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

    public static void main(String[] args) {
        Pets pets = new Pets();
        pets.run();
    }
}