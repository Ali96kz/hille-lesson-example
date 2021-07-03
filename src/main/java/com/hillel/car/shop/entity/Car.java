package com.hillel.car.shop.entity;

import java.util.Objects;

public class Car extends BaseEntity implements Comparable<Car> {

    private int price;
    private String name;
    private Brand brand;

    public Car() {
        super(null);
    }

    public Car(Integer id, int price, String name, Brand brand) {
        super(id);
        this.price = price;
        this.name = name;
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return price == car.price && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), price, brand);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + getId() +
                ", price=" + price +
                ", color='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        if (this.price > o.price) {
            return 1;
        } else if (this.price < o.price) {
            return -1;
        } else {
            return 0;
        }
    }
}
