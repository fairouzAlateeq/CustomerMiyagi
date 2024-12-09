DROP DATABASE IF EXISTS customerMiyagi;
CREATE DATABASE IF NOT EXISTS customerMiyagi;
USE customerMiyagi;

create table customer (
`customer_id` INTEGER NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`phone` VARCHAR(12),
CONSTRAINT `pk_customer` PRIMARY KEY (`customer_id`)
);

INSERT INTO `customer` (`customer_id`, `name`, `phone`) VALUES
('Debani', '555555555'),
('Sofia', '890123456'),
('Liam', '234567890'),
('Emma', '890123456'),
('Lucas', '202020202'),
('Diego', '222333444'),
('Hana', '333444555'),
('Ethan', '333333333'),
('Isabella', '444444444'),
('Noah', '111111111');
