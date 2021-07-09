/*
 * Copyright 2019 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package com.hillel.car.shop.dao;

import com.hillel.car.shop.entity.Car;

import java.util.List;

/**
 * @author Afanasev E.V.
 * @version 1.0 7/9/2021
 */
public interface CarDao {

    Integer create(Car car) throws DaoException;

    void delete(Car car) throws DaoException;

    List<Car> findAll() throws DaoException;

    Car getById(int id) throws DaoException;

}
