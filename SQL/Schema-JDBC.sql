CREATE DATABASE IF NOT EXISTS jdbcrud;

SHOW databases;

CREATE TABLE emp (
  empno decimal(4,0) NOT NULL,
  ename varchar(10) default NULL,
  job varchar(9) default NULL,
  mgr decimal(4,0) default NULL,
  hiredate date default NULL,
  sal decimal(7,2) default NULL,
  comm decimal(7,2) default NULL,
  deptno decimal(2,0) default NULL
);

drop table emp;

use jdbcrud;
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    age INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

drop table users;

CREATE TABLE products (
 product_id INT PRIMARY KEY,
 product_name VARCHAR(100) NOT NULL,
 category VARCHAR(50) NOT NULL,
 price DECIMAL(10,2) NOT NULL CHECK (price > 0),
 quantity INT NOT NULL CHECK (quantity >= 0),
 rating DECIMAL(2,1) NOT NULL CHECK (rating 
BETWEEN 1 AND 5),
 manufacturer VARCHAR(100),
 created_at TIMESTAMP DEFAULT 
CURRENT_TIMESTAMP
);

drop table products;

select * from products;

use jdbcrud;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);