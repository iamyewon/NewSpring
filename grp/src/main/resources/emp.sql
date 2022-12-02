create database grp;

use grp;

create table employees(
id bigint not null auto_increment,
username varchar(50),
email varchar(100),
passwd varchar(50),
primary key(id)
);