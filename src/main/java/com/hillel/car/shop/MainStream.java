package com.hillel.car.shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class MainStream {

    public static void main(String[] args) {
        SimpleArrayList simpleArrayList = new SimpleArrayList();

        for (Integer integer : simpleArrayList) {

        }

        Random random = new Random();
        List<String> stringList = new ArrayList<>();
        while (true) {
            stringList.add("asd" + random.nextDouble());
        }
    }

    public static class SimpleArrayList implements Iterable<Integer> {
        private List<Integer> odds = new ArrayList<>();

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        public class CustomIterator implements Iterator<Integer> {

            private Integer current;
            private Iterator<Integer> integerIterator = odds.iterator();

            @Override
            public boolean hasNext() {
                while (integerIterator.hasNext() && current == null) {
                    Integer next = integerIterator.next();
                    if (next % 2 == 0) {
                        current = integerIterator.next();
                    }
                }
                return false;
            }

            @Override
            public Integer next() {
                // TODO дописать
                return current;
            }
        }

    }


    private static void getOdds() {
        List<String> integers = Arrays.asList("200", "2200", "198", "23", "23", "40");

        List<Integer> odds = new ArrayList<>();
        for (String integer : integers) {
            int i = Integer.parseInt(integer);
            if (i % 2 == 0) {
                odds.add(i);
            }
        }

        integers = null;

        List<Integer> collect = integers.stream()
                .map(Integer::parseInt)
                .filter(inte -> inte % 2 == 0)
                .collect(Collectors.toList());
    }

    private static void forEachExample() {
        List<String> stringList = Arrays.asList("a", "B", "V", "D");
        stringList.stream()
                .map(string -> string + "@ithillel")
                .forEach(System.out::println);
    }

    private static void createSet() {
        List<String> stringList = Arrays.asList("a", "B", "V", "D");
        Set<String> collect = stringList.stream()
                .map(string -> string + "@ithillel")
                .collect(Collectors.toSet());
    }

    private static void createMap() {
        List<String> stringList = Arrays.asList("a", "B", "V", "D");
        Map<String, Integer> collect = stringList.stream()
                .map(string -> string + "@ithillel")
                .collect(Collectors.toMap((string) -> string, string -> string.length()));
    }

    private static void streamExample() {
        List<String> stringList = Arrays.asList("Mikhail", "Ali", "Dmitry");


        String joined = stringList.stream()
                .filter(string -> string.contains("A") || string.contains("a"))
                .map(string -> string + "@ithillel")
                .collect(Collectors.joining(", "));
        System.out.println(joined);
    }

    private static void testLambdaCreation() {
        List<String> stringList = Arrays.asList("Mikhail", "Ali", "Dmitry");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stringList) {
            stringBuilder.append(s).append(",");
        }
        String s = stringBuilder.toString();

        TestLambdaInterface testLambdaInterface = (value, count) -> {
            for (int i = 0; i < count; i++) {
                System.out.println(value);
            }

            return value.length();
        };

        Integer length = testLambdaInterface.print("Hello world", 5);
        System.out.println("Result " + length);
    }
}
