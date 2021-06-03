package com.hillel.car.shop;

public class ControllerResult {
    private final String view;

    public ControllerResult(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }
}
