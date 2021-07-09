package com.hillel.car.shop.service;

import java.util.List;

import com.hillel.car.shop.dao.CarDao;
import com.hillel.car.shop.dao.DaoException;
import com.hillel.car.shop.entity.Car;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarDao carDao;

    public CarService(CarDao carDao){
        this.carDao = carDao;
    }

    public List<Car> findAll() throws DaoException {
        List<Car> cars = carDao.findAll();
        return cars;
    }

    public Car findById(int id) throws ServiceException {
        try {
            return carDao.getById(id);
        } catch (DaoException e) {
            throw new ServiceException("");
        }
    }
}
