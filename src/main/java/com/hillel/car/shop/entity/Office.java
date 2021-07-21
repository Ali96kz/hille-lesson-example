/*
 * Copyright 2019 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package com.hillel.car.shop.entity;

import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author Afanasev E.V.
 * @version 1.0 7/17/2021
 */
@Entity
@Table(name = "office")
@Data
public class Office {

    @Id
//    @GeneratedValue(GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
    private Set<Employee> employeeList;

    @Override
    public String toString() {
        return "Office{" +
            "id=" + id +
            ", address='" + address + '\'' +
            '}';
    }
}
