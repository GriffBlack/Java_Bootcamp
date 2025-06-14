package org.example;

public abstract class Animal {
    private String name;
    private int age;
    private double weight;
    private double feed;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.feed = weight * 0.3;
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
        this.age = age;
    }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    abstract public double getFeedInfoKg();
}
