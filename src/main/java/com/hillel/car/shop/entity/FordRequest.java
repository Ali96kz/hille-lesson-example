package com.hillel.car.shop.entity;

public class FordRequest {
    private Ford ford;

    public Ford getFord() {
        return ford;
    }

    public void setFord(Ford ford) {
        this.ford = ford;
    }

    public byte[] toBytes() {
        return new byte[0];
    }
}
