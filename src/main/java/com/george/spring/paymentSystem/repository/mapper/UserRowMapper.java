package com.george.spring.paymentSystem.repository.mapper;

import com.george.spring.paymentSystem.domain.user.User;
import lombok.SneakyThrows;

import java.sql.ResultSet;

public class UserRowMapper {
    @SneakyThrows
    public static User mapRow(ResultSet resultSet) {
        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("user_id"));
            user.setUsername(resultSet.getString("user_username"));
            user.setPassword(resultSet.getString("user_password"));
            return user;
        }
        return null;
    }
}
