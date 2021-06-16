package com.hillel.car.shop.entity;

import java.util.Random;

public class TestHash {
    int i;

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public int hashCode() {
        return i;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
