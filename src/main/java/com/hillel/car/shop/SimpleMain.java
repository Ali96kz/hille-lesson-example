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

import com.hillel.car.shop.entity.Person;
import com.hillel.car.shop.entity.PersonLombok;

import java.awt.event.PaintEvent;

/**
 * @author Afanasev E.V.
 * @version 1.0 7/21/2021
 */
public class SimpleMain {
    public static void main(String[] args) {
//        final Person person = new Person("Evgenii","Afanasev","Afanasev","Afanasev","Afanasev",
//            "Afanasev","Afanasev","Afanasev",true,true,true);
//        final Person person1 = new Person();
//        person1.setFirstName("Evgenii");
//        person1.setMiddleName("Evgenii");
//        person1.setLastName("Evgenii");
//        person1.setCity("Moscow");

        Person person = Person.builder()
            .lastName("Afanasev")
            .streetAddress("Moscow")
            .employed(true)
            .female(false)
            .build();

        final PersonLombok personLombok = PersonLombok.builder()
            .suffix("dqwd")
            .firstName("dgerwg")
            .isEmployed(true)
            .build();
//        new PersonLombok("qweq","");
        personLombok.getMiddleName();
//        personLombok.se
    }
}
