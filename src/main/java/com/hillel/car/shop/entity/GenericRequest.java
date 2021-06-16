package com.hillel.car.shop.entity;

public class GenericRequest<T extends Car> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public byte[] toBytes() {
        return new byte[0];
    }
}
