package org.example;

public abstract class Animal {
    private String name;
    private int age;
    private double startTime;
    private double endTime;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getStartTime() {
        return startTime;
    }
    public double getEndTime() {
        return endTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }


    public abstract double goToWalk() throws InterruptedException;
    abstract public String toString();
}
