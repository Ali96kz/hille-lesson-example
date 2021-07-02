package com.hillel.car.shop.controller;

import com.hillel.car.shop.dao.DaoException;
import com.hillel.car.shop.entity.Car;
import com.hillel.car.shop.service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowAllCarsController implements Controller {

    private CarService carService = new CarService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Car> cars = carService.findAll();
            req.setAttribute("cars", cars);
            return new ControllerResultDto("cars");
        } catch (DaoException e) {
            return null;
        }
    }
}
