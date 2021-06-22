package com.hillel.car.shop;

import com.hillel.car.shop.entity.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Generic<T> {

    public <K, V extends Comparable> List<V> getSortedValue(Map<K, V> elements) {
        List<V> values = new ArrayList<>();
        for (Map.Entry<K, V> entry : elements.entrySet()) {
            values.add(entry.getValue());
        }

        Collections.sort(values);

        return values;
    }

    public void sortExample() {
        List<Car> cars = new ArrayList<>();
        cars.sort((car1, car2) -> {
            if (car1.getPrice() > car2.getPrice()) {
                return 1;
            } else if (car1.getPrice() < car2.getPrice()) {
                return -1;
            } else {
                return 0;
            }
        });

    }
}
