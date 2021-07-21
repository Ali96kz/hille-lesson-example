/*
 * Copyright 2019 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package com.hillel.car.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Afanasev E.V.
 * @version 1.0 7/9/2021
 */
@Configuration
@ComponentScan(basePackages = "com.hillel.car.shop")
@EnableJpaRepositories(basePackages = "com.hillel.car.shop.repository")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Autowired
    Environment env;

//    @Bean
//    public DataSource getDataSource() throws SQLException {
//        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
//        pgSimpleDataSource.setUser(env.getProperty("datasource.username"));
//        pgSimpleDataSource.setUrl(env.getProperty("datasource.url"));
//        pgSimpleDataSource.setPassword(env.getProperty("datasource.password"));
//        return pgSimpleDataSource.unwrap(DataSource.class);
//    }


}
