package com.hillel.car.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hillel.car.shop.entity.Brand;
import com.hillel.car.shop.utils.PostgresUtils;

public class BrandDAO {
    private static final String INSERT_SQL = "INSERT INTO brand(name) VALUES(?)";
    private static final String SELECT_ALL = "select id, name from brand";

    public Integer create(Brand brand) throws DaoException {
        try (Connection connection = PostgresUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            return preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new DaoException();
        }
    }

    public List<Brand> findAll() throws DaoException {
        List<Brand> brands = new ArrayList<>();
        try (
                Connection connection = PostgresUtils.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL);
        ) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Brand brand = new Brand(id, name);

                brands.add(brand);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throw new DaoException();
        }
        return brands;
    }

    public Brand findById(int id) {
        return new Brand(2, "asd");
    }
}
