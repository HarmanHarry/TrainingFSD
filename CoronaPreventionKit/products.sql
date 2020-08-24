drop database cpk;

create database cpk;

use cpk;

create table products(prodId INT PRIMARY KEY,
		prodName varchar(20) NOT NULL,
		prodDesc varchar(75),
		prodCost DECIMAL NOT NULL);
		

INSERT INTO products(prodId,prodName,prodDesc,prodCost) VALUES 
(1,"Face Mask","WildCraft Face Mask ",150),
(2,"Shield","Face Shield ",250),
(3,"Hand Sanitizer","LifeBoy Hand sanitizer - 1Ltr",450),
(4,"Hand Sanitizer","Detol Hand Sanitizer 500ml",280),
(5,"Digital Thermometer","Digital Thermometer - DT01",750),
(6,"PPE Kit","Personal Protection Equipment Kit",1200);