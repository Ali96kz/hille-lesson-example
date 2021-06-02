package com.hillel.car.shop;

import org.postgresql.core.ConnectionFactory;

public class CarSingleton {

    private final static CarSingleton carSingleton;
    private ConnectionFactory connectionFactory;

    static {
        carSingleton = new CarSingleton();
    }

    private CarSingleton() {
    }

    public static CarSingleton get() {
        if (carSingleton == null) {

        }
        return carSingleton;
    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }
}
