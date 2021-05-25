package com.hillel.lesson2.dao;

import com.hillel.lesson2.entity.Car;
import com.hillel.lesson2.utils.PostgresUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    private static final String SELECT_ALL = "select * from car";
    private static final String SELECT_BY_ID = "select * from car where id = ?";

    public void create(Car car) {

    }

    public void delete(Car car) {

    }

    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        try (
            Connection connection = PostgresUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
        ) {
            while (resultSet.next()) {
                Car car = new Car();
                car.setColor(resultSet.getString("color"));
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setDate(resultSet.getDate("date"));
                car.setPrice(resultSet.getInt("price"));
                cars.add(car);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return cars;
    }

    public Car getById(int id) {
        try (
            Connection connection = PostgresUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Car car = new Car();
                car.setColor(resultSet.getString("color"));
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setDate(resultSet.getDate("date"));
                car.setPrice(resultSet.getInt("price"));
                return car;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
