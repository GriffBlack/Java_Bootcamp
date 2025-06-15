package org.example;

import java.util.List;

public class AnimalIterator implements BaseIterator<Animal> {
    public List<Animal> animals;
    public int currentIndex;

    public AnimalIterator(List<Animal> animals) {
        this.animals = animals;
        this.currentIndex = 0;
    }

    @Override
    public Animal next() {
        return animals.get(currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < animals.size();
    }

    @Override
    public void reset() {
        currentIndex = 0;
    }

}
