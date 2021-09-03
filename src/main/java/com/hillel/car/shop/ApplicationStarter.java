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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Afanasev E.V.
 * @version 1.0 7/17/2021
 */
@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class);
//        try (final ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class)) {
//            final OfficeRepository officeRepository = ctx.getBean(OfficeRepository.class);
//            final List<Office> officeList = officeRepository.findAll();
//            officeList.forEach(System.out::println);
//            System.out.println();
//            final EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
//            final List<Employee> allByAgeBetween = employeeRepository.findAllByAgeBetween(10L, 40L);
//            final List<Employee> employees = employeeRepository.mySimpleMethod(222L);
//            employees.forEach(System.out::println);
//            System.out.println();
//            allByAgeBetween.forEach(System.out::println);
//
//
//            final List<Employee> employees1 = employeeRepository.mySimpleMethod2(222L);
//            System.out.println();
//
//            Employee employee = new Employee();
//            employee.setFirstName("Sergey2");
//            employee.setAge(25L);
//            employee.setIncome(20000L);
//            employeeRepository.save(employee);
//            System.out.println(employee);
//
//            employeeRepository.delete(employee);
//            Employee employee1 = new Employee();
//            employee1.setId(2L);
//            employeeRepository.delete(employee1);
//            System.out.println(employee1 + "\n удален");
//
//            final Employee employee2 = new Employee();
//            employee2.setIncome(1231L);
//            employeeRepository.delete(employee2);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
