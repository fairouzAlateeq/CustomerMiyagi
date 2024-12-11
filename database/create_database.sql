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
(1,'Debani', '555555555'),
(2,'Sofia', '890123456'),
(3,'Liam', '234567890'),
(4,'Emma', '890123456'),
(5,'Lucas', '202020202'),
(6,'Diego', '222333444'),
(7,'Hana', '333444555'),
(8,'Ethan', '333333333'),
(9,'Isabella', '444444444'),
(10,'Noah', '111111111');

create table product (
`product_id` INTEGER NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`price` float,
`category_id` int,
CONSTRAINT `pk_customer` PRIMARY KEY (`product_id`),
CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES category(`category_id`)
);

create table category (
`category_id` INTEGER NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
CONSTRAINT `category` PRIMARY KEY (`category_id`)
);

INSERT INTO category (`name`) VALUES
('Honey Products'),
('Beekeeping Equipment'),
('Supplements'),
('Candles'),
('Cosmetics'),
('Edible Items'),
('Frames'),
('Accessories'),
('Toys'),
('Gift Sets'),
('Raw Honey'),
('Organic Products'),
('Flavored Honey'),
('Syrups'),
('Tools'),
('Books'),
('Beeswax'),
('Propolis'),
('Royal Jelly');

-- Insert rows into the 'product' table
INSERT INTO product (`name`, `price`, `category_id`) VALUES
('Honey Jar', 9.99, 1),
('Honey Mustard', 7.99, 13),
('Propolis Soap', 2.99, 18),
('Lip Balm', 3.49, 5),
('Bee Wax Candle', 11.99, 4),
('Royal Jelly Supplement', 14.99, 19),
('Bee Pollen Granules', 14.99, 3),
('Honey Candy', 3.99, 6),
('Honeycomb Frame', 45.00, 7),
('Beekeeping Suit', 255.00, 2);