create database db_store;
use db_store;

create table store(
	id int not null AUTO_INCREMENT PRIMARY KEY,
   	name varchar(50) not null,
	date_create date not null,
   	date_update date not null
);