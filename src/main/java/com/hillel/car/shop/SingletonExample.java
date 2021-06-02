package com.hillel.car.shop;

public class SingletonExample {

    public static void main(String[] args) {
        CarSingleton carSingleton = CarSingleton.get();
        System.out.println(carSingleton);

        CarSingleton carSingleton2 = CarSingleton.get();
        System.out.println(carSingleton2);
    }
}
