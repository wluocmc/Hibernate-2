DROP DATABASE IF EXISTS `Hibernate-2`;
CREATE DATABASE `Hibernate-2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `Hibernate-2`;

DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer(
  id INT NOT NULL AUTO_INCREMENT,
  accountNum BIGINT DEFAULT NULL,
  firstName VARCHAR(30) NOT NULL ,
  lastName VARCHAR(30) NOT NULL ,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS Responsible;
CREATE TABLE Responsible(
  id INT NOT NULL AUTO_INCREMENT,
  customerId INT DEFAULT NULL ,
  firstName VARCHAR(30) NOT NULL ,
  lastName VARCHAR(30) NOT NULL ,
  accountNum BIGINT DEFAULT NULL,
  PRIMARY KEY (id)
--   FOREIGN KEY (customerId) REFERENCES Customer(id)
);

