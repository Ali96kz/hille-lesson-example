package com.hillel.car.shop.entity;

public class CarRequest {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public byte[] toBytes() {
        return new byte[0];
    }
}
