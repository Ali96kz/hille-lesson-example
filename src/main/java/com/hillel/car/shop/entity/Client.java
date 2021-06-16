package com.hillel.car.shop.entity;

import java.util.Objects;

public class Client extends User{

    private String name;

    public Client(Integer id, String name, String password) {
        super(id, name, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Client{}";
    }
}
