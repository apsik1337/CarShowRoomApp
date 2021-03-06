package com.alex.service.impl;


import com.alex.dao.CarDao;
import com.alex.model.Car;
import com.alex.model.Parameters;
import com.alex.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }


    @Override
    public List<Car> showAllCars() {
        try {
            return carDao.showAllCars();
        } catch (SQLException e) {
           log.error("SQLException in showAllCars", e);
        }
        return null;
    }

    @Override
    public List<Car> findCarByMaker(String maker) {
        try {
            return carDao.findCarByMaker(maker);
        } catch (SQLException e) {
            log.error("SQLException in findCarByMaker", e);
        }
        return null;
    }

    @Override
    public Car findCarById(int id) {
        try {
            return carDao.findCarById(id);
        } catch (SQLException e) {
            log.error("SQLException in findCarById", e);
        }
        return null;
    }

    @Override
    public List<Car> findCarByParams(Parameters parameters) {
        try {
            return carDao.findCarsByParams(parameters);
        } catch (SQLException e) {
            log.error("SQLException in findCarByParams", e);
        }
        return null;
    }

    @Override
    public boolean editCarByParams(Car car) {
       return carDao.editCarByParams(car);
    }

    @Override
    public boolean deleteCarById(int id) {
       return carDao.deleteCarById(id);
    }

    @Override
    public boolean addCar(Car car) {
       return carDao.addCar(car);
    }

    @Override
    public boolean orderCar(int userId, int carId, int enhanceId) {
       return carDao.orderCar(userId, carId, enhanceId);
    }

    @Override
    public boolean isAvailable(int id) {
        return carDao.isAvailable(id);
    }
}
