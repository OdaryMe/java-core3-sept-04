package ru.geekbrains.java_core3.lessons.l1_generics.hw_generics;

import java.util.ArrayList;
import java.util.List;
//

public class FruitBox <F extends Fruit> {
    private ArrayList<F> fruits;

    public FruitBox() {
        this.fruits = new ArrayList<F>();
    }

    public void addFruits(List<F> f) {
          this.fruits.addAll(f);
    }

    @Override
    public String toString() {
        return "FruitBox{" +
                "fruits=" + fruits +
                '}';
    }

    public float getWeight() {
        return fruits.size() * fruits.getFirst().getWeight();
    }

    public boolean compareBoxes(FruitBox<?> another) {
        return this.getWeight() - another.getWeight() < 0.00001;
    }

    public void moveFruitsToFrom(FruitBox<F> another) {
        this.fruits.addAll(another.fruits);
        another.fruits.removeAll(another.fruits);
    }
}