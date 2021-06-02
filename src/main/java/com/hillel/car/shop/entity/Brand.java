package com.hillel.car.shop.entity;

public class Brand extends BaseEntity {
    private String name;

    public Brand(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
