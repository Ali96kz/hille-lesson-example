package com.hillel.car.shop.entity;

public class User extends BaseEntity {

    private String name;
    private String password;
    private Basket basket;

    public User(Integer id, String name, String password, Basket basket) {
        super(id);
        this.name = name;
        this.basket = basket;
        this.password = password;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
