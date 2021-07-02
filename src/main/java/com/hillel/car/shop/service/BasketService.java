package com.hillel.car.shop.service;

import com.hillel.car.shop.dao.BasketDao;
import com.hillel.car.shop.entity.Basket;

public class BasketService {

    private BasketDao basketDao = new BasketDao();

    public Basket createOrUpdate(Basket basket) {
        return basketDao.create(basket);
    }

    public Basket findById(Integer id) {
        return basketDao.findById(id);
    }
}
