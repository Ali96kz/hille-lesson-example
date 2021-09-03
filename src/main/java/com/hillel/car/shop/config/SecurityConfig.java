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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Afanasev E.V.
 * @version 1.0 9/3/2021
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
//            .antMatchers("/**").permitAll()
//            .antMatchers(HttpMethod.GET, "/rest/employees/**").hasAnyRole(Role.ADMIN.name(), Role.USER.name())
//            .antMatchers(HttpMethod.POST, "/rest/employees/**").hasRole(Role.ADMIN.name())
//            .antMatchers(HttpMethod.DELETE, "/rest/employees/**").hasRole(Role.ADMIN.name())
//            .antMatchers(HttpMethod.PUT, "/rest/employees/**").hasRole(Role.ADMIN.name())
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        final UserDetails guest = User.builder()
            .username("guest")
            .password(passwordEncoder().encode("guest"))
            .roles(Role.GUEST.name())
            .build();
        final UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("admin"))
            .roles(Role.ADMIN.name())
            .build();
        final UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("user"))
            .roles(Role.USER.name())
            .build();
        return new InMemoryUserDetailsManager(admin, user, guest);
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
