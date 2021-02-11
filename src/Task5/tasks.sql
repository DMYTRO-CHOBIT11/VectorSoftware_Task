-- create tables
create table Products
(ProductID int auto_increment primary key,
 ProductName varchar(30),
 SupplierID int,
 CategoryID int,
 Price double,
 foreign key(SupplierID) references Suppliers(SupplierID),
 foreign key(CategoryID) references Categories(CategoryID));

create table Suppliers(
SupplierID int auto_increment primary key,
SupplierName varchar(30),
City varchar(30),
Country varchar(30)
);

create table Categories(
CategoryID int auto_increment primary key,
CategoryName varchar(30),
Description varchar(100));

-- Select product with product name that begins with ‘C’
select * from products where ProductName like "C%"

-- Select product with the smallest price
select * from products having min(price);

-- Select cost of all products from the USA.
select sum(price) from products
join suppliers
on products.SupplierID= suppliers.SupplierID
where country="USA";

-- Select suppliers that supply Condiments
SELECT SupplierName FROM Suppliers
JOIN Products ON Suppliers.SupplierID = Products.SupplierID
JOIN Categories ON Products.CategoryID = Categories.CategoryID
WHERE Categories.CategoryName = 'Condiments';

-- Add to database new supplier with name: ‘Norske Meierier’, city: ‘Lviv’, country: ‘Ukraine’
-- which will supply new product with name: ‘Green tea’, price: 10, and related to category with name: ‘Beverages’.
start transaction;
insert into suppliers(SupplierName,City,Country)
values("Norske Meierier’","Lviv","Ukraine");
insert into products(ProductName,SupplierID,CategoryID,Price)
values("Green tea",(select SupplierID from suppliers where SupplierName="Norske Meierier’"),1,10);
commit;

