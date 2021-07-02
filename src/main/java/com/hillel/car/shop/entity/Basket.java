package com.hillel.car.shop.entity;

import java.util.List;

public class Basket extends BaseEntity{

    private List<Car> cars;

    public Basket(Integer id, List<Car> cars) {
        super(id);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
