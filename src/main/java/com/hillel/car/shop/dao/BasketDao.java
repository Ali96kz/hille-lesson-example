package com.hillel.car.shop.dao;

import com.hillel.car.shop.entity.Basket;
import com.hillel.car.shop.entity.Car;
import com.hillel.car.shop.utils.PostgresUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class BasketDao {

    private Map<Integer, Basket> basketMap = new HashMap<>();
    private int autoincrementId = 0;

    public Basket create(Basket basket)  {
        autoincrementId++;
        basket.setId(autoincrementId);
        basketMap.put(basket.getId(), basket);
        return basket;
    }

    public Basket findById(Integer id) {
        return basketMap.get(id);
    }
}
