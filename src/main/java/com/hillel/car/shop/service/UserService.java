package com.hillel.car.shop.service;

import com.hillel.car.shop.dao.DaoException;
import com.hillel.car.shop.dao.UserDao;
import com.hillel.car.shop.entity.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public User getByUserName(String username) {
        try {
            return userDao.findByUsername(username);
        } catch (DaoException e) {
            System.out.println("Failed to find");
            return null;
        }
    }


    public User findById(Integer id) {
        try {
            return userDao.findByUsername(id);
        } catch (DaoException e) {
            System.out.println("Failed to find");
            return null;
        }
    }

}
