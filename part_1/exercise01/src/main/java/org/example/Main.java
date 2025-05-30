package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] coords = new double[6];
        String[] prompts = {
                "Enter x1: ", "Enter y1: ",
                "Enter x2: ", "Enter y2: ",
                "Enter x3: ", "Enter y3: "
        };;
        System.out.println("Введите координаты вершин треугольника:");
        for (int i = 0; i < 6; ) {
            System.out.print(prompts[i]);
            try {
                coords[i] = Double.parseDouble(scanner.nextLine());
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Couldn't parse a number. Please, try again");
            }
        }
        double[] sides = calculateSides(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
        if (isTriangle(sides[0], sides[1], sides[2])){
            double perimeter = calculatePerimeter(sides[0], sides[1], sides[2]);
            System.out.printf("Triangle perimeter: %.3f%n", perimeter);
        } else  {
            System.out.println("It isn't triangle");
        }

    }
    public static double calculatePerimeter(double a, double b, double c) {
        return a + b + c;
    }
    public static boolean isTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 &&
                a + b > c + 1e-10 &&
                a + c > b + 1e-10 &&
                b + c > a + 1e-10;
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static double[] calculateSides(double x1, double y1,
                                           double x2, double y2,
                                           double x3, double y3) {
        double a = calculateDistance(x1, y1, x2, y2);
        double b = calculateDistance(x2, y2, x3, y3);
        double c = calculateDistance(x1, y1, x3, y3);
        return new double[]{a, b, c};
    }
}