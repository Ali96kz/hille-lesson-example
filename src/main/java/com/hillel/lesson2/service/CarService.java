package com.hillel.lesson2.service;

import com.hillel.lesson2.dao.CarDao;
import com.hillel.lesson2.entity.Car;

import java.util.List;
import java.util.Objects;

public class CarService {

    private CarDao carDao;

    public CarService() {
        this.carDao = new CarDao();
    }

    public int sumPriceAllCars() {
        List<Car> cars = carDao.findAll();
        int totalSum = 0;
        for (Car car : cars) {
            totalSum += car.getPrice();
        }

        return totalSum;
    }

    public List<Car> findAll() {
        List<Car> cars = carDao.findAll();
        if (cars.isEmpty()) {
            System.out.println("Список автомобилей пуст");
        }
        return cars;
    }

    public Car getById(int id) {
        final Car byId = carDao.getById(id);
        if (Objects.isNull(byId)) {
            System.out.println(String.format("Автомобиль с id %d не найден", id));
        }
        return byId;
    }
}
