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

        try {
            System.out.println("Enter the number of pet: ");
            int numPets = Integer.parseInt(scanner.nextLine());
            if (numPets <= 0) {throw new NumberFormatException();}
            for (int i = 0; i < numPets; i++) {
                String type = scanner.nextLine();
                if (type.equalsIgnoreCase("cat") || type.equalsIgnoreCase("dog")) {
                    int age = 0;
                    String name = "";
                    boolean isValid = false;
                    name = scanner.nextLine();
                    while(!isValid) {
                        try {
                            age = Integer.parseInt(scanner.nextLine());
                            isValid = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid age format. Please enter a valid number.");
                        }
                    }
                    addPets(type, name, age);
                } else {
                    System.out.println("Incorrect input. Unsupported pet type");
                }
            }
            for (Animal pet : pets) {
                System.out.println(pet);
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format. Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.err.println("Incorrect input. Unsupported pet type");
        }
        catch (Exception e) {
            System.err.println("Error : " + e.getMessage());
        }
    }

    public void addPets(String type, String name, int age) {
        try {
            if(age <= 0) {
                throw new IllegalArgumentException("Incorrect input. Age <= 0");
            }

            Animal newPet;

            if (type.equalsIgnoreCase("cat")) {
                newPet = new Cat(name, age);
                pets.add(newPet);
            } else if (type.equalsIgnoreCase("dog")) {
                newPet = new Dog(name, age);
                pets.add(newPet);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Pets pets = new Pets();
        pets.run();
    }
}