/*
 * Copyright 2019 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package com.hillel.car.shop.controller.rest;

import com.hillel.car.shop.dto.EmployeeDTO;
import com.hillel.car.shop.entity.Employee;
import com.hillel.car.shop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Afanasev E.V.
 * @version 1.0 7/21/2021
 */
@RequestMapping(value = "/rest/employees", produces = MediaType.APPLICATION_JSON_VALUE)
//@Controller
//@ResponseBody
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

//    @RequestMapping(value = "/employee")
//    public List<Employee> getAll(){
//        return null;
//    }

//@RequestMapping(value = "/getTest2", method = RequestMethod.GET)
//    public String getSomeString2(){
//        return "test2";
//    }

    @RequestMapping(value = "/get-test", method = RequestMethod.GET)
    public String getSomeString() {
        return "test";
    }

    @GetMapping(value = "/get-one")
    public ResponseEntity<EmployeeDTO> getById(@RequestParam long id) {
//        Employee employee = Employee.builder()
//            .age(30L)
//            .firstName("Max")
//            .lastName("Petrov")
//            .build();
        final Employee employee = employeeService.getById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/get-one/{id}")
    public ResponseEntity<EmployeeDTO> getById2(@PathVariable long id) {
//        Employee employee = Employee.builder()
//            .age(30L)
//            .firstName("Max")
//            .lastName("Petrov")
//            .build();
        final Employee employee = employeeService.getById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        List<Employee> employeeList = employeeService.getAll();
        List<EmployeeDTO> employeeDTOList = employeeList.stream()
            .map(employee -> {
                EmployeeDTO employeeDTO = new EmployeeDTO();
                BeanUtils.copyProperties(employee, employeeDTO);
                return employeeDTO;
            })
            .collect(Collectors.toList());
        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
    }

}

