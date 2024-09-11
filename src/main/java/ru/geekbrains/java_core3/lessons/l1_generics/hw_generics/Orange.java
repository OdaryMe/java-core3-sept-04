package ru.geekbrains.java_core3.lessons.l1_generics.hw_generics;
//

public class Orange extends Fruit {

    public Orange() {
        this.weight = 1.5f;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange";
    }
}
