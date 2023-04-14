
delete from employee_account
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
primary key(book_id,author_id)
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
create table employee_account(
id int primary key,
fname varchar(255),
surname varchar(255),
email varchar(255),
password varchar(10)
);
create table checkout(
id int primary key,
s_time timestamp,
book_copy_id int foreign key references book_copy(id),
patron_account_id int foreign key references patron_account(id),
employee_account_id int foreign key references employee_account(id),
is_returned bit
);
create table hold(
id int primary key,
s_time timestamp,
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
insert into category(ID, name)
values ('1','Fantasy')
insert into book(ID, title, category_id)
values ('1','Harry Potter and the Philosopher’s Stone','1'),
('2','Harry Potter and the Chamber of Secrets','1'),
('3','Harry Potter and the Prisoner of Azkaban','1')
insert into author(ID, name)
values ('1','J. K. Rowling')
insert into book_author(book_id, author_id)
values ('1','1')
insert into publisher(id,name)
values ('1','Arthur A. Levine Books')
insert into book_copy(id,year_published,book_id,publisher_id)
values ('1','1997','1','1'),
('2','1997','1','1'),
('3','1998','2','1'),
('4','1998','2','1'),
('5','1999','3','1'),
('6','1999','3','1')
insert into patron_account(id,fname,surname,email,status)
values ('1','John','Cornor','jonnyC0420@gmail.com','active'),
('2','Joe','Cornor','joejoe2000@gmail.com','active')
insert into employee_account(id,fname,surname,email,password)
values ('1','Johnny','Marr','jonnythedon@gmail.com','1234'),
('2','Jenny','Carr','jcjcjc@gmail.com','1234')