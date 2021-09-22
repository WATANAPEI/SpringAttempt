create database if not exists state_of_emergency_db default character set utf8mb4;

create table if not exists state_of_emergency
(
    id NUMBER NOT NULL AUTO_INCREMENT,
    prefecture VARCHAR(30) NOT NULL,
    from VARCHAR(8) NOT NULL,
    to VARCHAR(8) NOT NULL,
    prefecture_name VARCHAR(30) NOT NULL,
    PRIMARY KEY (id),
    INDEX id_prefecture (prefecture)
);