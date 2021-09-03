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
import com.hillel.car.shop.dto.EmployeeExtensionDTO;
import com.hillel.car.shop.entity.Employee;
import com.hillel.car.shop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Afanasev E.V.
 * @version 1.0 7/21/2021
 */
@RequestMapping(value = "/rest/employees", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class EmployeeController {

    private final EmployeeService employeeService;

    @RequestMapping(value = "/get-test", method = RequestMethod.GET)
    public String getSomeString() {
        return "test";
    }

    @GetMapping(value = "/get-one")
    public ResponseEntity<EmployeeDTO> getById(@RequestParam long id) {
        final Employee employee = employeeService.getById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/get-one/{id}")
    public ResponseEntity<EmployeeDTO> getById2(@PathVariable long id) {

        final Employee employee = employeeService.getById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(employee, employeeDTO);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    //    @PreAuthorize("hasAnyRole('USER','ADMIN')")
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

    @GetMapping(value = "/filter")
    public ResponseEntity<List<EmployeeDTO>> getByName(
        @RequestParam String firstName,
        @RequestParam(required = false,defaultValue = "test") String lastName
    ) {
        List<Employee> employeeList = employeeService.getByName(firstName);
        List<EmployeeDTO> employeeDTOList = employeeList.stream()
            .map(employee -> {
                EmployeeDTO employeeDTO = new EmployeeDTO();
                BeanUtils.copyProperties(employee, employeeDTO);
                return employeeDTO;
            })
            .collect(Collectors.toList());
        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<EmployeeDTO>> getPage(
        @RequestParam(required = false, defaultValue = "1") Long ageFrom,
        @RequestParam(required = false, defaultValue = "999") Long ageTo,
        @RequestParam int pageSize,
        @RequestParam int pageNumber
    ) {
        final PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        final Page<Employee> pageEmployee = employeeService.getPage(ageFrom, ageTo, pageRequest);
        final Page<EmployeeDTO> pageEmployeeDTO = pageEmployee.map(employee -> {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employee, employeeDTO);
            return employeeDTO;
        });
        return new ResponseEntity<>(pageEmployeeDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> create(
        @RequestBody EmployeeDTO employeeDTO
    ) {
        final Employee employee = employeeService.create(employeeDTO);
        employeeDTO.setId(employee.getId());
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(
        @PathVariable Long id,
        @RequestBody EmployeeDTO employeeDTO
    ) {
        employeeService.update(id, employeeDTO);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping(path = "/create-employee-extension", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeExtensionDTO> createEmployeeExtensionDTO(
        @RequestBody EmployeeExtensionDTO employeeExtensionDTO
    ) {

        return new ResponseEntity<>(employeeExtensionDTO, HttpStatus.OK);
    }

}

