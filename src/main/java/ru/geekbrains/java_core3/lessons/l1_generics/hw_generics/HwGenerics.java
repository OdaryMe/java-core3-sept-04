package ru.geekbrains.java_core3.lessons.l1_generics.hw_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//lllll
public class HwGenerics {
    public static void main(String[] args) {
        String[] gadgets = {"Laptop", "Phone", "Tablet", "Player"};
        Integer[] num = {1, 3, 0, 9, 0};
        
//        1) Написать метод, который меняет два элемента массива местами
        changePlacesInsideArrGen(gadgets, 0, 3);
        changePlacesInsideArrGenVoid(gadgets, 1, 2);
        changePlacesInsideArrObj(gadgets, 0, 2);

//        2) Написать метод, который преобразует массив в ArrayList;
        System.out.println(myArrToList(num));

//        3) Сортируем апельсины и яблоки по коробкам. Сравниваем вес коробок. Пересыпаем фрукты туда-сюда.
        var apples1 = getFArraylistApples(6);
        var box1 = new FruitBox<Apple>();
        box1.addFruits(apples1);

        var apples2 = getFArraylistApples(3);
        var box2 = new FruitBox<Apple>();
        box2.addFruits(apples2);

        var oranges1 = getFArraylistOranges(1);
        var box3 = new FruitBox<Orange>();
        box3.addFruits(oranges1);

        var oranges2 = getFArraylistOranges(2);
        var box4 = new FruitBox<Orange>();
        box4.addFruits(oranges2);

        System.out.println(box1.toString());

        System.out.println(box4.getWeight()); //распечатываем вес коробки
        System.out.println(box2.compareBoxes(box4));//сравниваем вес коробок

        box1.moveFruitsToFrom(box2); //пересыпаем фрукты из коробки в коробку
        System.out.println(box1.toString());
        System.out.println(box2.toString());
//        box2.moveFruitsToFrom(box4); //если пытаемся добавить апельсины в коробку с яблоками, сразу подчеркивает красным
    }


    
    private static List<Apple> getFArraylistApples(int quantity) {
        List<Apple> apples = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            var apple = new Apple();
            apples.add(apple);
        }
        return apples;
    }

    private static List<Orange> getFArraylistOranges(int quantity) {
        List<Orange> oranges = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            var orange = new Orange();
            oranges.add(orange);
        }
        return oranges;
    }


    private static <E> List<E> myArrToList(E[] arr){
        List<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

    private static void changePlacesInsideArrObj(Object[] arr, int e1, int e2) {
        Object g = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = g;
        System.out.println(Arrays.toString(arr));
    }

    private static <E> void changePlacesInsideArrGenVoid(E[] arr, int e1, int e2) {
        E g = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = g;
        System.out.println(Arrays.toString(arr));
    }

    private static <E> E[] changePlacesInsideArrGen(E[] arr, int e1, int e2) {
        E g = arr[e1];
            arr[e1] = arr[e2];
            arr[e2] = g;
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
