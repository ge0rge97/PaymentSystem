package com.george.spring.paymentSystem.repository.mapper;

import com.george.spring.paymentSystem.domain.payment.Payment;
import com.george.spring.paymentSystem.domain.user.User;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PaymentRowMapper {
    @SneakyThrows
    public static Payment rowMapper(ResultSet resultSet) {
        if (resultSet.next()) {

            Payment payment = new Payment();
            payment.setId(resultSet.getLong("payment_id"));
            Timestamp timestamp = resultSet.getTimestamp("payment_date");
            if (!timestamp.equals(null)) {
                payment.setPaymentDate(timestamp.toLocalDateTime());
            }
            payment.setAmount(resultSet.getDouble("payment_amount"));

            User sender = new User();
            sender.setId(resultSet.getLong("sender_id"));
            sender.setUsername(resultSet.getString("sender_username"));
            sender.setPassword(resultSet.getString("sender_password"));
            payment.setSender(sender);

            User receiver = new User();
            receiver.setId(resultSet.getLong("receiver_id"));
            receiver.setUsername(resultSet.getString("receiver_username"));
            receiver.setPassword(resultSet.getString("receiver_password"));
            payment.setReceiver(receiver);

            return payment;
        }
        return null;
    }
    @SneakyThrows
    public static List<Payment> rowsMapper(ResultSet resultSet) {
        List<Payment> payments = new ArrayList<>();
        while (resultSet.next()) {
            Payment payment = new Payment();
            payment.setId(resultSet.getLong("payment_id"));
            if(!resultSet.wasNull()) {
                Timestamp timestamp = resultSet.getTimestamp("payment_date");
                if (!timestamp.equals(null)) {
                    payment.setPaymentDate(timestamp.toLocalDateTime());
                }
                payment.setAmount(resultSet.getDouble("payment_amount"));

                User sender = new User();
                sender.setId(resultSet.getLong("sender_id"));
                sender.setUsername(resultSet.getString("sender_username"));
                sender.setPassword(resultSet.getString("sender_password"));
                payment.setSender(sender);

                User receiver = new User();
                receiver.setId(resultSet.getLong("receiver_id"));
                receiver.setUsername(resultSet.getString("receiver_username"));
                receiver.setPassword(resultSet.getString("receiver_password"));
                payment.setReceiver(receiver);
            }
            payments.add(payment);
        }
        return payments;
    }
}
