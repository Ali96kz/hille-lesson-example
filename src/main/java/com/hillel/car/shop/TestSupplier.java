package com.hillel.car.shop;

import java.util.function.Supplier;

public class TestSupplier {

    Supplier<Generic> supplier;

    public void test() {
        try {
            System.out.println();
            System.out.println();
            System.out.println();
        } catch (Exception e) {
            Generic s = supplier.get();
        }
    }
}
