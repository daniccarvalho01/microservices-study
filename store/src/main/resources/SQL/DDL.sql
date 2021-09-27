create database store;
use store;

create table stores(
	id int not null AUTO_INCREMENT PRIMARY KEY,
   	name varchar(50) not null,
	date_create date not null,
   	date_update date not null
);