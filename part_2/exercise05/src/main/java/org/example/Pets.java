package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;
import java.util.*;
import java.util.stream.IntStream;

public class Pets {
    private final List<Animal> pets;
    private final Scanner scanner;
    private static final Instant programStart = Instant.now();

    private record WalkResult(Animal pet, Instant start, Instant end, double walkTime) {}

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

        ExecutorService executor = Executors.newFixedThreadPool(pets.size());
        List<Future<WalkResult>> futures = new ArrayList<>();

        for (Animal pet : pets) {
            Future<WalkResult> future = executor.submit(() -> {
                Instant start = Instant.now();
                pet.setStartTime(Duration.between(programStart, Instant.now()).toMillis() / 1000.0);
                double walkTime = pet.goToWalk();
                Instant end = Instant.now();
                pet.setEndTime(Duration.between(programStart, Instant.now()).toMillis() / 1000.0);
                return new WalkResult(pet, start, end, walkTime);
            });
            futures.add(future);
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }



        pets.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Pets pet = new Pets();
        pet.run();
    }
}