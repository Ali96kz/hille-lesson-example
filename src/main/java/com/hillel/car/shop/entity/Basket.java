package com.hillel.car.shop.entity;

import java.util.List;

public class Basket extends BaseEntity {

    private List<Car> cars;
    private User user;

    public Basket(Integer id, User user, List<Car> cars) {
        super(id);
        this.user = user;
        this.cars = cars;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
