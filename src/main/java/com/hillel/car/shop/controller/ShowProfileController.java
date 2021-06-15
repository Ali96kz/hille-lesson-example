package com.hillel.car.shop.controller;

import com.hillel.car.shop.entity.User;
import com.hillel.car.shop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowProfileController implements Controller{
    private UserService userService;

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        Object userId = req.getSession().getAttribute("userId");

        return null;
    }
}
