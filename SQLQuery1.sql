create database PRJ301
use PRJ301
create table category(
id int primary key,
name varchar(255) 
);
create table book(
id int primary key,
title varchar(255),
category_id int foreign key references category(id),
);
create table author(
id int primary key,
name varchar(255) 
);
create table book_author(
book_id int foreign key references book(id),
author_id int foreign key references author(id)
);
create table publisher(
id int primary key,
name varchar(255) 
);
create table book_copy(
id int primary key,
year_published int,
book_id int foreign key references book(id),
publisher_id int foreign key references publisher(id)
);
create table patron_account(
id int primary key,
fname varchar(255),
surname varchar(255),
email varchar(255),
status varchar(10)
);
create table checkout(
id int primary key,
s_time timestamp,
e_time timestamp,
book_copy_id int foreign key references book_copy(id),
patron_account_id int foreign key references patron_account(id),
is_returned bit
);
create table hold(
id int primary key,
s_time timestamp,
e_time timestamp,
book_copy_id int foreign key references book_copy(id),
patron_account_id int foreign key references patron_account(id),
);
create table waitlist(
patron_id int primary key foreign key references patron_account(id),
book_id int foreign key references book(id),
);
create table notification(
id int primary key,
send_at timestamp,
type varchar(20),
patron_account_id int foreign key references patron_account(id),
);
