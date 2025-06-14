package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Pets {
    private final List<Animal> pets;
    private final Scanner scanner;

    public Pets() {
        this.pets = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    private static Optional<Animal> readPet(Scanner scanner){
        try {
            String type = scanner.nextLine().trim().toLowerCase();
            if (!List.of("dog", "cat").contains(type)) {
                System.out.println("Incorrect input. Unsupported pet type");
                return Optional.empty();
            }
            String name = scanner.nextLine();

            int age = readPositiveInt(scanner);
            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
                return Optional.empty();
            }
            return Optional.of(type.equals("dog")
                    ? new Dog(name, age)
                    : new Cat(name, age));
        } catch (Exception e) {
            System.out.println("Could not parse a number. Please, try again");
            return Optional.empty();
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

    public void run() {
        int count = readPositiveInt(scanner);

        IntStream.range(0, count).forEach(i -> readPet(scanner).ifPresent(pets::add));

        pets.stream()
                .filter(pet -> pet.getAge() > 10)
                .forEach(Animal::increaseAge);

        pets.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Pets pet = new Pets();
        pet.run();
    }
}