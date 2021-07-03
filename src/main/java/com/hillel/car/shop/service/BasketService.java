package com.hillel.car.shop.service;

import com.hillel.car.shop.dao.BasketDao;
import com.hillel.car.shop.dao.DaoException;
import com.hillel.car.shop.entity.Basket;
import com.hillel.car.shop.entity.User;

import java.util.ArrayList;

public class BasketService {

    private BasketDao basketDao = new BasketDao();

    public Basket createOrUpdate(Basket basket) throws ServiceException {
        try {
            return basketDao.insertOrUpdate(basket);
        } catch (DaoException e) {
            throw new ServiceException("Failed to save into database");
        }
    }

    public Basket findOrCreateForUser(User user) throws ServiceException {
        try {
            Basket basket = basketDao.findById(user);

            return basket == null ? new Basket(null, user, new ArrayList<>()) : basket;
        } catch (DaoException e) {
            throw new ServiceException("Failed to find");
        }
    }
}
