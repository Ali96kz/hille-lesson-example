package com.hillel.car.shop.service;

import com.hillel.car.shop.dao.CarDao;
import com.hillel.car.shop.dao.DaoException;
import com.hillel.car.shop.entity.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    private final CarDao carDao;

    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
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
