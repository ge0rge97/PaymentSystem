package com.george.spring.paymentSystem.repository.impl;

import com.george.spring.paymentSystem.domain.payment.Payment;
import com.george.spring.paymentSystem.repository.DataSourceConfig;
import com.george.spring.paymentSystem.repository.PaymentRepository;
import com.george.spring.paymentSystem.repository.mapper.PaymentRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {
    private final DataSourceConfig dataSourceConfig;
    private final String FIND_BY_ID = """
            SELECT  p.id as payment_id,
                    p.payment_date as payment_date,
                    p.amount as payment_amount,
                    s.id as sender_id,
                    s.username as sender_username,
                    s.password as sender_password,
                    r.id as receiver_id,
                    r.username as receiver_username,
                    r.password as receiver_password
            FROM payment p
            LEFT JOIN users s ON p.sender_id = s.id
            LEFT JOIN users r ON p.receiver_id = r.id
            WHERE id = ?""";
    private final String FIND_ALL_BY_USER_ID = """
            SELECT  p.id as payment_id,
                    p.payment_date as payment_date,
                    p.amount as payment_amount,
                    s.id as sender_id,
                    s.username as sender_username,
                    s.password as sender_password,
                    r.id as receiver_id,
                    r.username as receiver_username,
                    r.password as receiver_password
            FROM payment p
            LEFT JOIN users s ON p.sender_id = s.id
            LEFT JOIN users r ON p.receiver_id = r.id
            WHERE p.receiver_id OR p.sender_id = ?""";
    private final String CREATE = """
            INSERT INTO payment (payment_date, amount, receiver_id, sender_id)
            VALUES (?, ?, ?, ?)""";
    private final String DELETE = """
            DELETE FROM payment
            WHERE id = ?""";

    @Override
    public Optional<Payment> findById(Long id) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return Optional.ofNullable(PaymentRowMapper.rowMapper(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Payment> findAllByUserId(Long id) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_USER_ID);
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return PaymentRowMapper.rowsMapper(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void create(Payment payment, Long receiverId, Long senderId) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            if (payment.getPaymentDate() == null) {
                statement.setNull(1, Types.TIMESTAMP);
            } else {
                statement.setTimestamp(1, Timestamp.valueOf(payment.getPaymentDate()));
            }
            statement.setDouble(2, payment.getAmount());
            statement.setLong(3, receiverId);
            statement.setLong(4, senderId);
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                resultSet.next();
                payment.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(Long id) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
