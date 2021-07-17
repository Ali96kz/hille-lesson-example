/*
 * Copyright 2019 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package com.hillel.car.shop.repository;

import com.hillel.car.shop.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Afanasev E.V.
 * @version 1.0 7/17/2021
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByAgeBetween(Long from, Long to);

    @Query(value = "select * from employee where income = :income_param", nativeQuery = true)
    List<Employee> mySimpleMethod(@Param("income_param") Long income);

    @Query("select e from Employee e join fetch e.office where e.income = :income_param")
    List<Employee> mySimpleMethod2(@Param("income_param") Long income);


}
