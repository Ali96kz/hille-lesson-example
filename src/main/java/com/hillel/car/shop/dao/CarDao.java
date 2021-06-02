package com.hillel.car.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hillel.car.shop.entity.Brand;
import com.hillel.car.shop.entity.Car;
import com.hillel.car.shop.utils.PostgresUtils;

public class CarDao {
    private BrandDAO brandDAO = new BrandDAO();
    private static final String CAR_FIELD = "price, colour, createdDate, brandId";
    private static final String SELECT_ALL = "select " + CAR_FIELD + " from car";
    private static final String SELECT_BY_ID = "select * from car where id = ?";
    private static final String INSERT_SQL = "INSERT INTO car(" + CAR_FIELD + ") VALUES(?, ?, ?, ?)";

    private static final String GET_FULL_CAR = "select c.id, c.name, b.id, b.name " +
            " from car c " +
            " inner join brand b on b.id = c.brandId";

    public Integer create(Car car) throws DaoException {
        try (Connection connection = PostgresUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, car.getPrice());
            preparedStatement.setString(2, car.getColor());
            preparedStatement.setDate(3, car.getDate());
            preparedStatement.setInt(4, car.getBrand().getId());

            return preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException();
        }
    }

    public void delete(Car car) {

    }

    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        try (
                Connection connection = PostgresUtils.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(GET_FULL_CAR);
        ) {
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("c.id"));
                car.setBrand(new Brand(resultSet.getInt("b.id"), resultSet.getString("b.name")));
                cars.add(car);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return cars;
    }

    public Car getById(int id) throws DaoException {
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
                car.setDate(resultSet.getDate("date"));
                car.setPrice(resultSet.getInt("price"));
                return car;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new DaoException();
        }
        return null;
    }
}
