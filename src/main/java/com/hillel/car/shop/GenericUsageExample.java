package com.hillel.car.shop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenericUsageExample {

    public static void main(String[] args) {
        Generic<String> example = new Generic<>();
        Map<String, Integer> map = new HashMap<>();

        map.put("5", 5);
        map.put("2", 2);
        map.put("4", 4);
        map.put("3", 3);

        List<Integer> sortedValue = example.getSortedValue(map);

        String collect = sortedValue.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));

        System.out.println(collect);
    }

}
