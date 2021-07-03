package com.hillel.car.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

    ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp);
}
