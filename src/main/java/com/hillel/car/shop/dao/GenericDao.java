package com.hillel.car.shop.dao;

import com.hillel.car.shop.entity.BaseEntity;
import com.hillel.car.shop.entity.Brand;
import com.hillel.car.shop.entity.Car;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericDao<T extends BaseEntity> {
   /*

   Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public List<T> findAll() {
        Set<FieldDto> fields = new HashSet<>();

        for (Method method : clazz.getMethods()) {
            String name = method.getName();
            if (name.startsWith("get")) {
                FieldDto fieldDto = new FieldDto();
                fieldDto.name = name.substring(3);
                fieldDto.type = method.getReturnType();
                fields.add(fieldDto);
            }
        }

        String sqlWithReflection = "SELECT ";
        for (FieldDto field : fields) {
            sqlWithReflection += " " + field.name + " ,";
        }

        sqlWithReflection += " FROM " + clazz.getSimpleName();

        ResultSet resultSet = null;

        while (resultSet.next()) {
            Car car = new Car();
            for (FieldDto field : fields) {
                Object value;
                if (field.type instanceof String) {
                    value = resultSet.getString()
                } else if (field.type instanceof Double) {
                    value = resultSet.getDouble(field.name);
                    fields1[0].setDouble(car, value);
                }

                Field[] fields1 = car.getClass().getFields();

            }

        }

        return new ArrayList<>();
    }

    private class FieldDto {
        Class type;
        String name;
    }
*/
}
