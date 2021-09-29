create database if not exists state_of_emergency_db default character set utf8mb4;
use state_of_emergency_db;
drop table if exists state_of_emergency;

create table if not exists state_of_emergency
(
    id int NOT NULL AUTO_INCREMENT,
    prefecture VARCHAR(30) NOT NULL,
    effective_from VARCHAR(8) NOT NULL,
    effective_to VARCHAR(8) NOT NULL,
    prefecture_name VARCHAR(30) NOT NULL,
    PRIMARY KEY (id),
    INDEX id_prefecture (prefecture)
);