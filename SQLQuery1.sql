
drop database PRJ301
create database PRJ301
use PRJ301
create table category(
id int identity(1,1) primary key,
name varchar(255) 
);
create table book(
id int identity(1,1) primary key,
title varchar(255),
category_id int foreign key references category(id),
pic_link varchar(255)
);
create table author(
id int identity(1,1) primary key,
name varchar(255) 
);
create table book_author(
book_id int foreign key references book(id),
author_id int foreign key references author(id)
primary key(book_id,author_id)
);
create table publisher(
id int identity(1,1) primary key,
name varchar(255) 
);
create table book_copy(
id int identity(1,1) primary key,
year_published int,
book_id int foreign key references book(id),
publisher_id int foreign key references publisher(id),
is_returned bit
);
create table patron_account(
id int identity(1,1) primary key,
fname varchar(255),
surname varchar(255),
email varchar(255),
status varchar(10)
);
create table employee_account(
id int identity(1,1) primary key,
fname varchar(255),
surname varchar(255),
email varchar(255),
password varchar(10)
);
create table checkout(
id int primary key,
s_time datetime,
book_copy_id int foreign key references book_copy(id),
patron_account_id int foreign key references patron_account(id),
employee_account_id int foreign key references employee_account(id),
);
create table hold(
id int identity(1,1) primary key,
s_time datetime,
e_time datetime,
book_copy_id int foreign key references book_copy(id),
patron_account_id int foreign key references patron_account(id)
);
create table waitlist(
id int identity(1,1) primary key,
patron_id int foreign key references patron_account(id),
book_name varchar(255)
);
create table notification(
id int identity(1,1) primary key,
send_at datetime,
type varchar(20),
patron_account_id int foreign key references patron_account(id),
);
insert into category(name)
values ('Fantasy')
insert into book(title, category_id, pic_link)
values ('Harry Potter and the Philosopher’s Stone','1','images/R.jpg'),
('Harry Potter and the Chamber of Secrets','1','images/C.jpg'),
('Harry Potter and the Prisoner of Azkaban','1','images/A.jpg')
insert into author(name)
values ('J. K. Rowling')
insert into book_author(book_id, author_id)
values ('1','1')
insert into publisher(name)
values ('Arthur A. Levine Books')
insert into book_copy(year_published,book_id,publisher_id,is_returned)
values ('1997','1','1',0),
('1997','1','1',0),
('1998','2','1',0),
('1998','2','1',0),
('1999','3','1',0),
('1999','3','1',0)
insert into patron_account(fname,surname,email,status)
values ('Dung','Hoang','dungthhe170357@fpt.edu.vn','active'),
('John','Cornor','jonnyC0420@gmail.com','active'),
('Joe','Cornor','joejoe2000@gmail.com','active')
insert into employee_account(fname,surname,email,password)
values ('Johnny','Marr','jonnythedon@gmail.com','1234'),
('Jenny','Carr','jcjcjc@gmail.com','1234')
select * from patron_account
Update patron_account set fname='Jose', surname='Nai', email='josenaine@gmail.com',status='active' where id=4