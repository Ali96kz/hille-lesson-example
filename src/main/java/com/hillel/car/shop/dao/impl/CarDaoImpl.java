package com.hillel.car.shop.dao.impl;

import com.hillel.car.shop.dao.CarDao;
import com.hillel.car.shop.dao.DaoException;
import com.hillel.car.shop.entity.Brand;
import com.hillel.car.shop.entity.Car;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final DataSource dataSource;

    private static final String SELECT_BY_ID = "" +
        "select c.id       as carId," +
        "       c.name     as carName," +
        "       c.price    as carPrice," +
        "       brand.id   as brandId," +
        "       brand.name as brandName" +
        " from car c " +
        "         inner join brand brand on brand.id = c.brandId" +
        " where c.id = ?";
    private static final String INSERT_SQL = "INSERT INTO car(price, colour, createdDate, brandId) VALUES(?, ?, ?, ?)";

    private static final String GET_FULL_CAR = "select c.id, c.name, c.price, brand.id as brandId, brand.name as brandName" +
        " from car c " +
        " left join brand brand on brand.id = c.brand_id";

    private static final String DELETE_SQL = "Delete from car where id = ?";

    public CarDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Integer create(Car car) throws DaoException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, car.getPrice());
            preparedStatement.setString(2, car.getName());
            preparedStatement.setInt(4, car.getBrand().getId());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public void delete(Car car) throws DaoException {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
            preparedStatement.setInt(1, car.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public List<Car> findAll() throws DaoException {
        List<Car> cars = new ArrayList<>();
        try (
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_FULL_CAR);
        ) {
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setName(resultSet.getString("name"));
                car.setBrand(new Brand(resultSet.getInt("brandId"), resultSet.getString("brandName")));
                car.setPrice(resultSet.getInt("price"));
                cars.add(car);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new DaoException("Failed to save");
        }
        return cars;
    }

    @Override
    public Car getById(int id) throws DaoException {
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int brandId = resultSet.getInt("brandId");
                String brandName = resultSet.getString("brandName");
                Brand brand = new Brand(brandId, brandName);

                Car car = new Car();
                car.setBrand(brand);
                car.setId(resultSet.getInt("carId"));
                car.setName(resultSet.getString("carName"));
                car.setPrice(resultSet.getInt("carPrice"));
                return car;
            }

            return null;
        } catch (SQLException throwables) {
            throw new DaoException("failed to get all", throwables);
        }
    }
}
