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
('1','Debani', '555555555'),
('2','Sofia', '890123456'),
('3','Liam', '234567890'),
('4','Emma', '890123456'),
('5','Lucas', '202020202'),
('6','Diego', '222333444'),
('7','Hana', '333444555'),
('8','Ethan', '333333333'),
('9','Isabella', '444444444'),
('10','Noah', '111111111');

create table product (
`product_id` INTEGER NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`type` VARCHAR(12),
CONSTRAINT `pk_customer` PRIMARY KEY (`product_id`)
);

INSERT INTO `product` (`product_id`, `name`, `type`) VALUES
(1, 'Honey Jar', 'Food'),
(2, 'Honey Mustard', 'Food'),
(3, 'Propolis Soap', 'Personal Care'),
(4, 'Lip Balm', 'Personal Care'),
(5, 'Bee Wax Candle', 'Home Decor'),
(6, 'Royal Jelly Supplement', 'Health'),
(7, 'Bee Pollen Granules', 'Health'),
(8, 'Honey Candy', 'Snack'),
(9, 'Honeycomb Frame', 'Beekeeping'),
(10, 'Beekeeping Suit', 'Beekeeping');