--liquibase formatted sql
--changeset techgeeknext:create-tables

create table if not exists users
(
    id bigint AUTO_INCREMENT,
    username varchar(50) NOT NULL,
    password varchar(255) NOT NULL,
    password_confirmation varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

create table if not exists payment_method
(
    id bigint AUTO_INCREMENT,
    number bigint NOT NULL,
    current_balance DOUBLE NOT NULL,
    payment_method_type varchar(255) NOT NULL,
    user_id bigint NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    PRIMARY KEY (id)
);

create table if not exists payment
(
    id bigint AUTO_INCREMENT,
    payment_date TIMESTAMP NOT NULL,
    amount DOUBLE NOT NULL,
    receiver_id bigint NOT NULL,
    sender_id bigint NOT NULL,
    FOREIGN KEY (receiver_id) REFERENCES users(id),
    FOREIGN KEY (sender_id) REFERENCES users(id),
    PRIMARY KEY (id)
);
