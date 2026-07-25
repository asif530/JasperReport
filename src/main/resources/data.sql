INSERT INTO product (id, name, price, quantity, category_name) VALUES (1, 'fashion 4', 1.0, 3, 'Category 1');
INSERT INTO product (id, name, price, quantity, category_name) VALUES (2, 'fashion 3', 1.0, 3, 'Category 1');
INSERT INTO product (id, name, price, quantity, category_name) VALUES (3, 'fashion 2', 1.0, 3, 'Category 1');
INSERT INTO product (id, name, price, quantity, category_name) VALUES (4, 'fashion 1', 1.0, 3, 'Category 2');
INSERT INTO product (id, name, price, quantity, category_name) VALUES (5, 'computer 3', 1.0, 3, 'Category 2');
INSERT INTO product (id, name, price, quantity, category_name) VALUES (6, 'computer 2', 1.0, 3, 'Category 3');
INSERT INTO product (id, name, price, quantity, category_name) VALUES (7, 'computer 1', 1.0, 3, 'Category 3');
INSERT INTO product (id, name, price, quantity, category_name) VALUES (8, 'mobile 1', 20.0, 7, 'Category 3');

ALTER TABLE product ALTER COLUMN id RESTART WITH 9;
