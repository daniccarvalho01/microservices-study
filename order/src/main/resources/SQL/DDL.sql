CREATE DATABASE db_order;
use  db_order;


create table orders(
	id int not null AUTO_INCREMENT PRIMARY KEY,
    store_id int not null,
	date date not null,
    address varchar(250) not null
);

create table order_item(
	id int not null AUTO_INCREMENT PRIMARY KEY,
	order_id int not null,
	product_id int not null,
    quantity int not null,
	unit_price double not null
);