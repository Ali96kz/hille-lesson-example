package com.hillel.lesson2.service;

import java.util.List;

import com.hillel.lesson2.dao.CarDao;
import com.hillel.lesson2.entity.Car;

public class CarService {

    private CarDao carDao;

    public int sumPriceAllCars() {
        List<Car> cars = carDao.findAll();
        int totalSum = 0;
        for (Car car : cars) {
            totalSum += car.getPrice();
        }

        return totalSum;
    }
}
