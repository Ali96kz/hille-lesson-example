package com.hillel.car.shop.service;

import com.hillel.car.shop.dao.DaoException;
import com.hillel.car.shop.entity.Car;


import java.util.List;

public interface CarDao {

    Integer create(Car car) throws DaoException;

    void delete(Car car) throws DaoException;

    List<Car> findAll() throws DaoException;

    Car getById(int id) throws DaoException;
}
