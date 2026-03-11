CREATE DATABASE inventory_db;

USE inventory_db;

CREATE TABLE products (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    category VARCHAR(50),
    price DOUBLE,
    quantity INT,
    rating DOUBLE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

select * from products;