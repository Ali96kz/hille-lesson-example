package com.hillel.car.shop.dao;

import com.hillel.car.shop.entity.Brand;
import com.hillel.car.shop.entity.Car;
import com.hillel.car.shop.entity.User;
import com.hillel.car.shop.utils.PostgresUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private BasketDao basketDao = new BasketDao();

    public User findByUsername(String username) throws DaoException {
        try (
                Connection connection = PostgresUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select id, username, password from users where username = ?");
        ) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String usernameField = resultSet.getString(2);
                String password = resultSet.getString(3);
                int basketId = resultSet.getInt(4);

                return new User(id, usernameField, password, basketDao.findById(basketId));
            }

            return null;
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new DaoException();
        }
    }
}
