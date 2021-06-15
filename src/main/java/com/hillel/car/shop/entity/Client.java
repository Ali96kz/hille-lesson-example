package com.hillel.car.shop.entity;

public class Client extends User{

    public Client(Integer id, String name, String password) {
        super(id, name, password);
    }

    @Override
    public String toString() {
        return "Client{}";
    }
}
