CREATE DATABASE  IF NOT EXISTS `db_banalysis`; USE `db_banalysis`;

DROP TABLE IF EXISTS `user`; 
SET character_set_client = utf8mb4 ; 

CREATE TABLE `user` (
`username` varchar(16) NOT NULL,
`usertype` varchar(255) DEFAULT NULL,  
`password` varchar(32) NOT NULL,  
`id` int(11) NOT NULL AUTO_INCREMENT,  
PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `datacustomer`; 
CREATE TABLE `datacustomer`( 
`name` varchar(16) NOT NULL, 
`surname` varchar(16) NOT NULL, 
`age` int(11) NOT NULL, 
`email` varchar(32) NOT NULL, 
`phonenumber` varchar(11) NOT NULL, 
`id` int(11) NOT NULL AUTO_INCREMENT, 
PRIMARY KEY (`id`) 
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
DROP TABLE IF EXISTS `supplier`; 
CREATE TABLE `supplier`( 
`name` varchar(16) UNIQUE NOT NULL, 
`country` varchar(16) NOT NULL, 
`email` varchar(32) NOT NULL, 
`id` int(11) NOT NULL AUTO_INCREMENT, 
PRIMARY KEY (`id`) 
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 DROP TABLE IF EXISTS `order`; 
 CREATE TABLE `order`( 
 `quantity` int(10) NOT NULL 
 CHECK(`quantity`>=0), 
 `orderNumber` varchar(32) NOT NULL, 
 `date` varchar(32)  NOT NULL, 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
 PRIMARY KEY (`id`)
 )ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 
 DROP TABLE IF EXISTS `warehouse`; 
 CREATE TABLE `warehouse`( 
 `city` varchar(20) NOT NULL, 
 `capacity` int(10) NOT NULL, 
 `id` int(11) NOT NULL AUTO_INCREMENT, 
 PRIMARY KEY (`id`) 
 )ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
