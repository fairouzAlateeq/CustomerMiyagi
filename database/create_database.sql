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

create table category (
`category_id` INTEGER NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
CONSTRAINT `category` PRIMARY KEY (`category_id`)
);

INSERT INTO `category` (`category_id`,`name`) VALUES
(1,'Honey Products'),
(2, 'Beekeeping Equipment'),
(3, 'Supplements'),
(4, 'Candles'),
(5, 'Cosmetics'),
(6, 'Edible Items'),
(7, 'Frames'),
(8, 'Accessories'),
(9, 'Toys'),
(10,'Gift Sets'),
(11,'Raw Honey'),
(12,'Organic Products'),
(13,'Flavored Honey'),
(14,'Syrups'),
(15,'Tools'),
(16,'Books'),
(17,'Beeswax'),
(18,'Propolis'),
(19,'Royal Jelly');

create table product (
`product_id` INTEGER NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`price` float,
`category_id` int,
CONSTRAINT `pk_customer` PRIMARY KEY (`product_id`),
CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES category(`category_id`)
);


-- Insert rows into the 'product' table
INSERT INTO `product` (`product_id`,`name`, `price`, `category_id`) VALUES
(1,'Honey Jar', 9.99, 1),
(2,'Honey Mustard', 7.99, 13),
(3,'Propolis Soap', 2.99, 18),
(4, 'Lip Balm', 3.49, 5),
(5, 'Bee Wax Candle', 11.99, 4),
(6, 'Royal Jelly Supplement', 14.99, 19),
(7, 'Bee Pollen Granules', 14.99, 3),
(8, 'Honey Candy', 3.99, 6),
(9, 'Honeycomb Frame', 45.00, 7),
(10, 'Beekeeping Suit', 255.00, 2);