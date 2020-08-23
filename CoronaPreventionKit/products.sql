create database cpk;

use cpk;

create table products(prodId INT PRIMARY KEY, prodName varchar(20) NOT NULL,prodDesc varchar(50),prodCost DECIMAL NOT NULL);

INSERT INTO products(prodId,prodName,prodDesc,prodCost) VALUES (1,"Mask","Face Mask ",50.0),(2,"Shield","Face Shield ",250),(3,"Sanitizer","Hand Sanitizer 500ml",100);