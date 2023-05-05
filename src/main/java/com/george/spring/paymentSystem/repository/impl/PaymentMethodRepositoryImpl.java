package com.george.spring.paymentSystem.repository.impl;

import com.george.spring.paymentSystem.domain.paymentMethod.PaymentMethod;
import com.george.spring.paymentSystem.repository.DataSourceConfig;
import com.george.spring.paymentSystem.repository.PaymentMethodRepository;
import com.george.spring.paymentSystem.repository.mapper.PaymentMethodRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {
    private final DataSourceConfig dataSourceConfig;
    private final String FIND_BY_ID = """
            SELECT  pm.id as payment_method_id,
                    pm.number as payment_method_number,
                    pm.current_balance as payment_method_current_balance,
                    pm.payment_method_type as payment_method_payment_method_type
            FROM payment_method pm
            WHERE id = ?""";
    private final String FIND_BY_NUMBER = """
            SELECT pm.id as payment_method_id,
                    pm.number as payment_method_number,
                    pm.current_balance as payment_method_current_balance,
                    pm.payment_method_type as payment_method_payment_method_type
            FROM payment_method pm
            WHERE id = ?""";
    private final String FIND_ALL_BY_USER_ID = """
            SELECT pm.id as payment_method_id,
                    pm.number as payment_method_number,
                    pm.current_balance as payment_method_current_balance,
                    pm.payment_method_type as payment_method_payment_method_type
            FROM payment_method pm
              JOIN users u on pm.user_id = u.id
            WHERE u.id = ?""";
    private final String CREATE = """
            INSERT INTO payment_method (number, current_balance, payment_method_type, user_id) 
                    VALUES (?, ?, ?, ?)""";
    private final String DELETE = """
            DELETE FROM payment_method
            WHERE id = ?""";

    @Override
    public Optional<PaymentMethod> findById(Long id) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return Optional.ofNullable(PaymentMethodRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Optional<PaymentMethod> findByNumber(Long number) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_NUMBER);
            statement.setLong(1, number);
            try (ResultSet resultSet = statement.executeQuery()) {
                return Optional.ofNullable(PaymentMethodRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<PaymentMethod> findAllByUserId(Long userId) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_USER_ID);
            statement.setLong(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return PaymentMethodRowMapper.mapRows(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void create(PaymentMethod paymentMethod, Long userId) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, paymentMethod.getNumber());
            statement.setDouble(2, paymentMethod.getCurrentBalance());
            statement.setString(3, paymentMethod.getPaymentMethodType().name());
            statement.setLong(4, userId);
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                resultSet.next();
                paymentMethod.setId(resultSet.getLong(1));
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
