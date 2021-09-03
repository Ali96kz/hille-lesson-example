/*
 * Copyright 2019 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package com.hillel.car.shop.service.impl;

import com.hillel.car.shop.dto.EmployeeDTO;
import com.hillel.car.shop.entity.Employee;
import com.hillel.car.shop.repository.EmployeeRepository;
import com.hillel.car.shop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author Afanasev E.V.
 * @version 1.0 7/21/2021
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getById(Long id) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> {
                throw new RuntimeException("не удалось найти Employee с id " + id);
            });
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getByName(String name) {
        return employeeRepository.findAllByFirstName(name);
    }

    public Page<Employee> getPage(Long ageFrom, Long ageTo, Pageable pageable) {
        return employeeRepository.findAllByAgeBetweenOrderByAge(ageFrom, ageTo, pageable);
    }

    @Override
    @Transactional
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public Employee create(EmployeeDTO employeeDTO) {
        if (!Objects.isNull(employeeDTO.getId())){
            throw new IllegalArgumentException("internal error");
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if(!employeeRepository.existsById(id)){
            throw new IllegalArgumentException(String.format("No Employee with id %s exists!",id));
        }
        employeeRepository.deleteById(id);
    }

    @Override
    public void update(Long id, EmployeeDTO employeeDTO) {
        if(!employeeRepository.existsById(id)){
            throw new IllegalArgumentException(String.format("No Employee with id %s exists!",id));
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employee.setId(id);
        employeeRepository.save(employee);
    }
}
