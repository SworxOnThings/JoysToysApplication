DROP TABLE IF EXISTS Customer_Order_Product_Association, Payment_information, Customer,Customer_Order, Customer_transactions, Categories, Products, Suppliers, Delivery, Inventory_Order, Inventory_Transactions, Restocking_Logistics, Job_Role, Employee;

CREATE TABLE Customer (
	Customer_ID serial primary key,
	Name varchar(255) NOT NULL,
	Email varchar(255),
	Address varchar(255),
	PhoneNumber varchar(255)
);

CREATE TABLE Payment_Information (
	Payment_Information_ID serial primary key,
	Credit_Card_Number varchar(255),
	Kind int,
	Customer_ID int references Customer(Customer_ID)
);

CREATE TABLE Customer_Order (
	Customer_Order_ID serial primary key,
	Customer_Order_date TIMESTAMP WITH TIME ZONE NOT NULL,
	Customer_ID int references Customer(Customer_ID)
);

CREATE TABLE Customer_Transactions (
	Customer_Transaction_ID serial primary key,
	Amount_Paid numeric,  
	Customer_Order_ID int references Customer_Order(Customer_Order_ID),
	Payment_Information_ID int references Payment_Information(Payment_Information_ID)
);

CREATE TABLE Categories (
	Category_ID serial primary key,
	Category_Name varchar(255)
);

CREATE TABLE Products (
	Product_ID serial primary key,
	Product_Name varchar(255),
	Price numeric,
	Product_Stock int,
	ImageURL varchar(255),
	category int references categories(category_id)
);

CREATE TABLE Customer_Order_Product_Association (
	Customer_Order_Product_Association_id serial primary key,
	Customer_Order_ID int references Customer_Order(Customer_Order_ID),
	Product_ID int references Products(Product_ID),
	UNIQUE(Customer_Order_ID, Product_ID),
	Quantity int
);


CREATE TABLE Suppliers (
	Supplier_ID serial primary key,
	Name varchar(255),
	Address varchar(255),
	PhoneNumber varchar(255),
	email varchar(255)
);

CREATE TABLE Inventory_Order (
	Inventory_Order_ID serial primary key,
	Inventory_Order_date TIMESTAMP WITH TIME ZONE NOT NULL,
	PurchasingPricePerUnit numeric,
	Product_ID int references Products(Product_ID),
	Supplier_ID int references Suppliers(supplier_id)
);

CREATE TABLE Delivery (
	Delivery_ID serial primary key,
	Expected_Delivery_date TIMESTAMP WITH TIME ZONE NOT NULL,
	Arrival_date TIMESTAMP WITH TIME ZONE NOT NULL,
	Inventory_Order_ID int references Inventory_Order(Inventory_Order_ID),
	Supplier_ID int references Suppliers(Supplier_ID)
);

CREATE TABLE Inventory_Transactions (
	Transaction_ID serial primary key,
	Amount_paid numeric,
	Inventory_Order_ID int references Inventory_Order(Inventory_Order_ID)
);

CREATE TABLE Restocking_Logistics (
	restocking_logistics_id serial primary key,
	product_id int references Products(product_id),
	inventory_order_id int references inventory_order(inventory_order_id),
	UNIQUE(product_id, inventory_order_id),
	quantity int
);

CREATE TABLE Job_Role (
	Job_ID serial primary key,
	Hourly_rate numeric,
	Job_Title varchar(255)
);

CREATE TABLE Employee (
	Employee_ID serial primary key,
	Name varchar(255),
	email varchar(255),
	Address varchar(255),
	PhoneNumber varchar(255),
	Bank_Account_Number int, 
	Hours_worked int,
	Job_ID int references Job_Role(Job_ID)
);