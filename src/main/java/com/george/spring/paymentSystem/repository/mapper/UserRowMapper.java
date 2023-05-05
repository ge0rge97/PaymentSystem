package com.george.spring.paymentSystem.repository.mapper;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.domain.user.User;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.List;

public class UserRowMapper {
    @SneakyThrows
    public static User mapRow(ResultSet resultSet) {
        List<PaymentMethod> paymentMethods = PaymentMethodRowMapper.mapRows(resultSet);
        resultSet.beforeFirst();

        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("user_id"));
            user.setUsername(resultSet.getString("user_username"));
            user.setPassword(resultSet.getString("user_password"));
            user.setPaymentMethods(paymentMethods);
            return user;
        }
        return null;
    }
}
