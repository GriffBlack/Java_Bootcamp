package org.example;

import java.util.concurrent.TimeUnit;

public class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public double goToWalk() {
        double walkTime = getAge() * 0.25;
        try {
            TimeUnit.SECONDS.sleep((long) walkTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return walkTime;
    }

    @Override
    public String toString() {
        return String.format("Cat name = %s, age = %d, start time = %.2f, end time = %.2f",
                getName(), getAge(), getStartTime(), getEndTime());
    }
}
