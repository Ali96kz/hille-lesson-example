package com.hillel.car.shop.entity;

import java.sql.Date;
import java.util.Objects;

public class Car extends BaseEntity {

    private int price;
    private String color;
    private Brand brand;
    private Date date;

    public Car() {
        super(2);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return price == car.price && Objects.equals(brand, car.brand) && Objects.equals(date, car.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), price, brand, date);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + getId() +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", date=" + date +
                '}';
    }
}
