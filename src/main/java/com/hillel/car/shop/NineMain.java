package com.hillel.car.shop;

import com.hillel.car.shop.entity.Car;
import com.hillel.car.shop.entity.TestHash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NineMain {

    private static Object Car;

    public static void main(String[] args) {
        Map<TestHash, String> map = new HashMap<>();
        TestHash key1 = new TestHash();
        TestHash key2 = new TestHash();
        key1.setI(2);
        key2.setI(2);

        map.put(key1, "222");
        map.put(key2, "333");

        System.out.println(map.get(key1));
        System.out.println(map.get(key2));
    }
}

