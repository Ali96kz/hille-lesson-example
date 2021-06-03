package com.hillel.car.shop.controller;

import com.hillel.car.shop.ControllerResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowPageController implements Controller {

    private final String URL;

    public ShowPageController(String URL) {
        this.URL = URL;
    }

    @Override
    public ControllerResult execute(HttpServletRequest req, HttpServletResponse resp) {
        return new ControllerResult(URL);
    }
}
