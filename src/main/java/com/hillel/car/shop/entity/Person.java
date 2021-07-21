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

/**
 * @author Afanasev E.V.
 * @version 1.0 7/21/2021
 */
public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String salutation;
    private String suffix;
    private String streetAddress;
    private String city;
    private String state;
    private boolean isFemale;
    private boolean isEmployed;
    private boolean isHomeOwner;


    public static Builder builder() {
        return new Person().new Builder();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public boolean isHomeOwner() {
        return isHomeOwner;
    }

    public class Builder {

        public Builder lastName(String lastName) {
            Person.this.lastName = lastName;
            return this;
        }

        public Builder firstName(String firstName) {
            Person.this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            Person.this.middleName = middleName;
            return this;
        }

        public Builder salutation(String salutation) {
            Person.this.salutation = salutation;
            return this;
        }

        public Builder suffix(String suffix) {
            Person.this.suffix = suffix;
            return this;
        }

        public Builder streetAddress(String streetAddress) {
            Person.this.streetAddress = streetAddress;
            return this;
        }

        public Builder city(String city) {
            Person.this.city = city;
            return this;
        }

        public Builder state(String state) {
            Person.this.state = state;
            return this;
        }

        public Builder female(boolean female) {
            Person.this.isFemale = female;
            return this;
        }

        public Builder employed(boolean employed) {
            Person.this.isEmployed = employed;
            return this;
        }

        public Builder homeOwner(boolean homeOwner) {
            Person.this.isHomeOwner = homeOwner;
            return this;
        }

        public Person build() {
            return Person.this;
        }
    }
}
