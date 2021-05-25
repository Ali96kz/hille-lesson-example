/*
 * Copyright 2019 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package com.hillel.lesson2;

import com.hillel.lesson2.entity.Car;
import com.hillel.lesson2.service.CarService;

import java.util.List;

/**
 * @author Afanasev E.V.
 * @version 1.0 5/25/2021
 */
public class Lesson3Main {
    public static void main(String[] args) {
        CarService service = new CarService();
        List<Car> allCars = service.findAll();
        for (Car car : allCars) {
            System.out.println(car);
        }
//        allCars.forEach(System.out::println);
        final Car byId = service.getById(10);
        System.out.println(byId);
    }
}
