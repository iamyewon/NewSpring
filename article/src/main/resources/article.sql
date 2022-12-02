create database article;

use article;

create table article(
id int not null auto_increment primary key,
subject varchar(200),
content text
);