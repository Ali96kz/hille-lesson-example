package com.hillel.car.shop.controller;

import com.hillel.car.shop.ControllerResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    ControllerResult execute(HttpServletRequest req, HttpServletResponse resp);

}
