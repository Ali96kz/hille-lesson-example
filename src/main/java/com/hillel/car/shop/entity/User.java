package com.hillel.car.shop.entity;

public class User extends BaseEntity {

    private String name;
    private String password;

    public User(Integer id, String name, String password) {
        super(id);
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
