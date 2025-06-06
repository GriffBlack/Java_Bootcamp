package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter the number of Strings:");
            List<String> strings = new ArrayList<>();
            if (scan.hasNextInt()) {
                int count = scan.nextInt();
                while(count != 0) {
                    strings.add(scan.next());
                    count--;
                }
                String subString = scan.next();
                for (String st : strings) {
                    if (st.contains(subString)) {
                    System.out.print(st);
                        if (!strings.get(strings.size() - 1).equals(st)) {
                            System.out.print(", ");
                        }
                    }
                }
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