

--INSERT INTO Customer values(DEFAULT ,'John', 'none@none.com', '123 somewhere st.', '543-555-2013');

--INSERT INTO Payment_Information values(DEFAULT, '1234-4567-8900-0012', 1, 1);

--INSERT INTO Categories values(DEFAULT, 'Toy Guns');

--INSERT INTO Products values(DEFAULT, 'Super Nerf Blaster 9000', 20.00, 3);

/*
INSERT INTO products_categories_junction 
values(1, 1);

INSERT INTO Customer_Order values 
(DEFAULT, now(), 1);

INSERT INTO customer_order_product_association values(DEFAULT, 1, 1, 3);

SELECT * FROM customer_order_product_association;
*/

--SELECT * FROM products_categories_junction;

--INSERT INTO inventory_order values(DEFAULT, now(), 20.00, 50, 1);

--INSERT INTO inventory_transactions values(DEFAULT, 1000.00, 3);

--INSERT INTO suppliers values
--(DEFAULT, 'Hasbro', '1027 Newport Avenue Pawtucket, RI 02862.', '401-123-6969');

--INSERT INTO delivery values(DEFAULT, now(), 3, 1);

--SELECT * FROM inventory_order;

--SELECT * FROM inventory_transactions;

--SELECT * FROM suppliers;

--SELECT * FROM delivery;

--INSERT INTO job_role values(DEFAULT, 0.20, 'Stocker');

--INSERT INTO Employee values
--(DEFAULT, 'Peter Parker', 'parkerp@webhead.com', '123 hero ln', '212-123-4567', '611199955', 25, 1);

--SELECT * FROM Employee;