package com.george.spring.paymentSystem.repository.mapper;


import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethodType;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodRowMapper {
    @SneakyThrows
    public static PaymentMethod mapRow(ResultSet resultSet) {
        if (resultSet.next()) {
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setId(resultSet.getLong("payment_method_id"));
            paymentMethod.setNumber(resultSet.getLong("payment_method_number"));
            paymentMethod.setCurrentBalance(resultSet.getDouble("payment_method_current_balance"));
            paymentMethod.setPaymentMethodType(PaymentMethodType.valueOf(resultSet.getString("payment_method_payment_method_type")));
            return paymentMethod;
        }
        return null;
    }
    @SneakyThrows
    public static List<PaymentMethod> mapRows(ResultSet resultSet) {
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        while (resultSet.next()) {
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setId(resultSet.getLong("payment_method_id"));
            if(!resultSet.wasNull()) {
                paymentMethod.setNumber(resultSet.getLong("payment_method_number"));
                paymentMethod.setCurrentBalance(resultSet.getDouble("payment_method_current_balance"));
                paymentMethod.setPaymentMethodType(PaymentMethodType.valueOf(resultSet.getString("payment_method_payment_method_type")));
            }
            paymentMethods.add(paymentMethod);
        }
        return paymentMethods;
    }
}
