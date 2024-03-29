package com.george.spring.paymentSystem.repository.impl;

import com.george.spring.paymentSystem.domain.user.User;
import com.george.spring.paymentSystem.exception.ResourceMappingException;
import com.george.spring.paymentSystem.repository.DataSourceConfig;
import com.george.spring.paymentSystem.repository.UserRepository;
import com.george.spring.paymentSystem.repository.mapper.UserRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final DataSourceConfig dataSourceConfig;
    private final String FIND_BY_ID = """
        SELECT u.id as user_id,
               u.username as user_username,
               u.password as user_password,
               pm.id as payment_method_id,
               pm.number as payment_method_number,
               pm.current_balance as payment_method_current_balance,
               pm.payment_method_type as payment_method_payment_method_type,
               p.id as payment_id,
               p.payment_date as payment_date,
               p.amount as payment_amount,
               p.receiver_id as payment_receiver_id,
               p.sender_id as payment_sender_id
        FROM users u
        LEFT JOIN payment_method pm ON u.id = pm.user_id
        LEFT JOIN payment p ON u.id = p.receiver_id OR u.id = p.sender_id
        WHERE u.id = ?""";
    private final String FIND_BY_USERNAME = """
        SELECT u.id as user_id,
               u.username as user_username,
               u.password as user_password,
               pm.id as payment_method_id,
               pm.number as payment_method_number,
               pm.current_balance as payment_method_current_balance,
               pm.payment_method_type as payment_method_payment_method_type,
               p.id as payment_id,
               p.payment_date as payment_date,
               p.amount as payment_amount,
               p.receiver_id as payment_receiver_id,
               p.sender_id as payment_sender_id
        FROM users u
        LEFT JOIN payment_method pm ON u.id = pm.user_id
        LEFT JOIN payment p ON u.id = p.receiver_id OR u.id = p.sender_id
        WHERE u.username = ?""";
    private final String CREATE = """
            INSERT INTO users (username, password, password_confirmation)
            VALUES (?, ?, ?)""";
    private final String DELETE = """
            DELETE FROM users
            WHERE id = ?""";

    @Override
    public Optional<User> findById(Long id) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return Optional.ofNullable(UserRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new ResourceMappingException("Error while finding user by id.");
        }
    }
    @Override
    public Optional<User> findByUsername(String username) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_USERNAME,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                return Optional.ofNullable(UserRowMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            throw new ResourceMappingException("Error while finding user by username.");
        }
    }
    @Override
    public void create(User user) {
        try {
            Connection connection = dataSourceConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getPasswordConfirmation());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                resultSet.next();
                user.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            throw new ResourceMappingException("Error while creating new user.");
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
            throw new ResourceMappingException("Error while deleting user.");
        }
    }
}
