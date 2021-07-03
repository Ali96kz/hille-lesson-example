package com.hillel.car.shop.controller;

import com.hillel.car.shop.entity.Basket;
import com.hillel.car.shop.entity.Car;
import com.hillel.car.shop.entity.User;
import com.hillel.car.shop.service.BasketService;
import com.hillel.car.shop.service.CarService;
import com.hillel.car.shop.service.ServiceException;
import com.hillel.car.shop.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBasketController implements Controller {

    private final UserService userService = new UserService();
    private final CarService carService = new CarService();
    private final BasketService basketService = new BasketService();

    @Override
    public ControllerResultDto execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String carId = req.getParameter("carId");
            Car car = carService.findById(Integer.parseInt(carId));

            Integer userId = (Integer) req.getSession().getAttribute("userId");

            User user = userService.findById(userId);
            Basket basket = basketService.findOrCreateForUser(user);
            basket.getCars().add(car);
            basketService.createOrUpdate(basket);

            return new ControllerResultDto("cars", true);
        } catch (ServiceException e) {
            return new ControllerResultDto("error-500");
        }
    }
}
