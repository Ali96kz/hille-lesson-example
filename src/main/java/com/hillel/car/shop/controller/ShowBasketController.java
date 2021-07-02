package com.hillel.car.shop.controller;

import com.hillel.car.shop.entity.User;
import com.hillel.car.shop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowBasketController implements Controller {

    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        Integer userId = (Integer) req.getSession().getAttribute("userId");
        User user = userService.findById(userId);

        req.setAttribute("basket", user.getBasket());
        return null;
    }
}
