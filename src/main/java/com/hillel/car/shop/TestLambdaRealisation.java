package com.hillel.car.shop;

public class TestLambdaRealisation implements TestLambdaInterface {

    @Override
    public Integer print(String value, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(value);
        }

        return value.length();
    }
}
