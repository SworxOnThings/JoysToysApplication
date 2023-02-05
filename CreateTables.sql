DROP TABLE IF EXISTS Customer, Customer_Order, Customer_transactions, Categories, Products, Products_Categories_Junction, Suppliers, Delivery, Inventory_Order, Inventory_Transactions, Job_Role, Employee;

CREATE TABLE Customer (
	Customer_ID serial primary key,
	Name varchar(255) NOT NULL,
	Email varchar(255),
	Address varchar(255),
	PhoneNumber varchar(255)
);

CREATE TABLE Customer_Order (
	Customer_Order_ID serial primary key,
	Customer_Order_date TIMESTAMP WITH TIME ZONE NOT NULL,
	Quantity int,
	Customer_ID int references Customer(Customer_ID)
);

CREATE TABLE Customer_Transactions (
	Customer_Transaction_ID serial primary key,
	Amount_Paid numeric,  
	Customer_Order_ID int references Customer_Order(Customer_Order_ID)
);

CREATE TABLE Categories (
	Category_ID serial primary key,
	Category_Name varchar(255)
);

CREATE TABLE Products (
	Product_ID serial primary key,
	Product_Name varchar(255),
	Price numeric
);

CREATE TABLE Products_Categories_Junction (
	Category_ID int references Categories(Category_ID),
	Product_ID int references Products(Product_ID)
);

CREATE TABLE Suppliers (
	Supplier_ID serial primary key,
	Name varchar(255),
	Address varchar(255),
	PhoneNumber varchar(255),
	email varchar(255)
);

CREATE TABLE Delivery (
	Delivery_ID serial primary key,
	Delivery_date TIMESTAMP WITH TIME ZONE NOT NULL,
	Supplier_ID references Suppliers(Supplier_ID)
);

CREATE TABLE Inventory_Order (
	Inventory_Order_ID serial primary key,
	Inventory_Order_date TIMESTAMP WITH TIME ZONE NOT NULL,
	PurchasingPricePerUnit numeric,
	Quantity int,
	Delivery_ID references Delivery(Delivery_ID),
	Product_ID references Products(Product_ID)
);

CREATE TABLE Inventory_Transactions (
	Transaction_ID serial primary key,
	Amount_paid numeric,
	Inventory_Order_ID references Inventory_Order(Inventory_Order_ID)
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
	Bank_Account_No. int, 
	Hours_worked int,
	Job_ID references Job_Role(Job_ID)
);