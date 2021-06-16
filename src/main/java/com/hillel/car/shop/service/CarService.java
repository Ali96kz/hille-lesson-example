package com.hillel.car.shop.service;

import java.util.ArrayList;
import java.util.List;

import com.hillel.car.shop.dao.BrandDAO;
import com.hillel.car.shop.dao.CarDao;
import com.hillel.car.shop.dao.DaoException;
import com.hillel.car.shop.entity.Brand;
import com.hillel.car.shop.entity.Car;
import com.hillel.car.shop.entity.Ford;

public class CarService {

    private CarDao carDao;
    private BrandDAO brandDAO;

    public CarService() {
        this.carDao = new CarDao();
    }

    public int sumPriceAllCars() throws DaoException {
        List<Car> cars = carDao.findAll();
        int totalSum = 0;
        for (Car car : cars) {
            totalSum += car.getPrice();
        }

        return totalSum;
    }

    public void sumPriceWithObjects() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Ford());

    }

    public List<Car> findAll() throws DaoException {
        List<Car> cars = carDao.findAll();
        for (Car car : cars) {
            Integer id = car.getBrand().getId();
            Brand brand = brandDAO.findById(id);
            car.setBrand(brand);
        }
        return cars;
    }

    public Car getById(int id) throws ServiceException {
        try {
            return carDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException("");
        }
    }
}
