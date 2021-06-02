package com.hillel.car.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hillel.car.shop.controller.ControllerFactory;

@WebServlet("/flower-shop/*")
public class DispatcherServlet extends HttpServlet {

    private ControllerFactory actionFactory;

    @Override
    public void init() throws ServletException {
        actionFactory = new ControllerFactory();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        } catch (Exception e) {
            throw new ServletException("Cannot execute action", e);
        }
    }
}
