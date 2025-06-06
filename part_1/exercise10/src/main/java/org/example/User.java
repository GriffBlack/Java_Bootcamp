package org.example;


public class User {
    private String name;
    private int age;
    public User(String name, int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Incorrect input. Age <= 0");
        }
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Incorrect input. Age <= 0");
        }
        this.age = age;
    }
}

