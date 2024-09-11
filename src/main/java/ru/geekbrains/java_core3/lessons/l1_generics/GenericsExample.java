package ru.geekbrains.java_core3.lessons.l1_generics;

import java.util.Collections;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
//        simpleBoxExample();
//        genericBoxExample();
//        numbersExample();
        comparingFloats();
        var ints1 = List.of(1, 2, 44);//List.of == Arrays.asList
        var ints2 = List.of(231, 2, 44);
//        System.out.println((Integer) getFirstObject(ints1) + (Integer) getFirstObject(ints2));
//        System.out.println(getFirstObjectGen(ints1) + getFirstObjectGen(ints2));

//        Collections.copy();//см.обобщенный метод в библиотеке, для примера использования супер и икстендс
    }

    //обобщенный метод:
    private static <T> T getFirstObjectGen(List<T> list) {
        return list.get(0);
    }

    private static Object getFirstObject(List list) {
        return list.get(0);
    }

    private static void numbersExample() {
        var boxI = new BoxWithNumbers<>(1000, 127, 3001, 519, 47);
        var boxD = new BoxWithNumbers<>(1000.0, 127.0, 3001.0, 519.0, 47.0);
//        var boxS = new BoxWithNumbers<String>("1000.0"); - mustn't! have to extend Number
//        System.out.println(boxD);
        System.out.println(boxI.avg());
        System.out.println(boxD.equalsByAvg(boxI));
//        boxI.setNumbers(new Float[] {1f, 2f}); - mustn't! we have int
    }

    private static void comparingFloats() {
        var a = 0.7;
        var b = 0.0;
        for (int i = 0; i < 70; i++) {
            b += 0.01;
        }
        System.out.println(a == b); //напишет фолс, потому что:
        System.out.printf("A = %f, B = %f\n", a, b);
        System.out.println("A = " + a + " B = " + b);
    }

    private static void genericBoxExample() {
        var boxInt1 = new GenericBox<>(100500);
        var boxInt2 = new GenericBox<>(1);
        var boxString1 = new GenericBox<>("Hello ");
        var boxString2 = new GenericBox<>("world");
//        GenericBox<Integer> box = new GenericBox<>(4); //полное объявление со всеми церемониями
//        GenericBox box = new GenericBox(4); //Raw use

        var sum = 0;
        sum = boxInt1.getObj() + boxInt2.getObj();
    }

    private static void simpleBoxExample() {
        var boxInt1 = new Box(100500);
        var boxInt2 = new Box(1);
        var boxString1 = new Box("Hello ");
        var boxString2 = new Box("world");

        var sum = 0;
        if (boxInt1.getObj() instanceof Integer && boxInt2.getObj() instanceof Integer) {
            sum = (Integer) boxInt1.getObj() + (Integer) boxInt2.getObj();
        }
    }
}
