package com.hillel.car.shop.dao;

import com.hillel.car.shop.entity.Basket;
import com.hillel.car.shop.entity.Brand;
import com.hillel.car.shop.entity.Car;
import com.hillel.car.shop.entity.User;
import com.hillel.car.shop.utils.PostgresUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasketDao {

    private static final String INSERT_SQL = "INSERT INTO basket(userId, carId) VALUES(?, ?)";
    private static final String DELETE_BASKET_SQL = "DELETE FROM Basket WHERE userId = ?";
    private static final String FIND_BY_ID = "select " +
            "basket.id as basketId, " +
            "c.id       as carId, " +
            "c.name     as carName, " +
            "c.price    as carPrice, " +
            "b.id       as brandId, " +
            "b.name     as brandName " +
            "FROM basket basket " +
            " INNER JOIN users u on u.id = basket.userId " +
            " INNER JOIN car c on c.id = basket.carId " +
            " INNER JOIN brand b on c.brandid = b.id  " +
            " where u.id = ?";


    public Basket insertOrUpdate(Basket basket) throws DaoException {
        deleteBasket(basket);
        try {
            for (Car car : basket.getCars()) {
                try (Connection connection = PostgresUtils.getConnection();
                     PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
                    preparedStatement.setInt(1, basket.getUser().getId());
                    preparedStatement.setInt(2, car.getId());
                    preparedStatement.execute();
                }
            }

            return basket;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException();
        }
    }

    public void deleteBasket(Basket basket) throws DaoException {
        try (Connection connection = PostgresUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BASKET_SQL)) {
            preparedStatement.setInt(1, basket.getUser().getId());
            preparedStatement.execute();

        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException();
        }
    }

    public Basket findById(User user) throws DaoException {
        try (Connection connection = PostgresUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            Basket basket = new Basket(null, null, null);
            ArrayList<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                int basketId = resultSet.getInt("basketId");
                basket.setId(basketId);

                Integer id = resultSet.getInt("brandId");
                String name = resultSet.getString("brandName");
                Brand brand = new Brand(id, name);

                int carId = resultSet.getInt("carId");
                String carName = resultSet.getString("carName");
                int carPrice = resultSet.getInt("carPrice");

                Car car = new Car(carId, carPrice, carName, brand);
                cars.add(car);
            }
            basket.setCars(cars);
            basket.setUser(user);

            if (basket.getId() == null) {
                return null;
            }

            return basket;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException();
        }
    }
}
