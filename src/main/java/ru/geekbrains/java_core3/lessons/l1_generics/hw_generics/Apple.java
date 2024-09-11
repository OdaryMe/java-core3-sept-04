package ru.geekbrains.java_core3.lessons.l1_generics.hw_generics;

import java.util.ArrayList;

public class Apple extends Fruit {

    public Apple() {
        this.weight = 1.0f;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple";
    }
}
