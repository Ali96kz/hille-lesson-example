package com.hillel.car.shop.controller;

import com.hillel.car.shop.entity.User;
import com.hillel.car.shop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller{

    private UserService userService = new UserService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");

        User user = userService.findByUserName(userName);

        if(user.getPassword().equals(password)) {
            req.setAttribute("user", user);

            HttpSession session = req.getSession();
            session.setAttribute("userId", user.getId());
            return new ControllerResultDto("profile");
        } else {
            return new ControllerResultDto("error-403");
        }
    }
}
