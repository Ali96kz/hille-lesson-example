/*
 * Copyright 2019 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package com.hillel.car.shop;

import com.hillel.car.shop.config.ApplicationConfig;
import com.hillel.car.shop.entity.Car;
import com.hillel.car.shop.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

/**
 * @author Afanasev E.V.
 * @version 1.0 7/9/2021
 */
public class SpringMain {
    public static void main(String[] args) {
        try (
//            final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-app.xml")
//            final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com/hillel/car/shop")
            final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class)
        ) {
            final String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
            System.out.println(Arrays.toString(beanDefinitionNames));
            final CarService carService = ctx.getBean(CarService.class);
            final List<Car> all = carService.findAll();
            System.out.println(all.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
