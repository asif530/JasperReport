DROP TABLE IF EXISTS product;

CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    price DECIMAL(10, 1) NOT NULL,
    quantity INT NOT NULL,
    category_name VARCHAR(250) NOT NULL
);
