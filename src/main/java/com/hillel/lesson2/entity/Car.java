package com.hillel.lesson2.entity;

import java.sql.Date;
import java.util.Objects;

public class Car {
    private int id;
    private int price;
    private String color;
    private String brand;
    private Date date;

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && price == car.price && Objects.equals(color, car.color) && Objects.equals(brand, car.brand) && Objects.equals(date, car.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, color, brand, date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Car{" +
            "id=" + id +
            ", price=" + price +
            ", color='" + color + '\'' +
            ", brand='" + brand + '\'' +
            ", date=" + date +
            '}';
    }
}
