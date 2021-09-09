create table admin
(
	adminname varchar(30) primary key,
	password varchar(10)
);

insert into admin values('admin','admin');

------------------------------------------------------------

create table doctor
(
	id int(5) primary key auto_increment,
	firstname varchar(30) not null,
	lastname varchar(30)not null,
	speciality varchar(50),
	dob varchar(20),
	contact varchar(10),
	gender varchar(10),
	emailid varchar(30),
	permanentaddress varchar(100),
	presentaddress varchar(100)
);

-------------------------------------------------------------

create table patient
(
	id int(5) primary key auto_increment,
	firstname varchar(30) not null,
	lastname varchar(30) not null,
	disease varchar(50),
	dob varchar(20),
	gender varchar(10),
	weight varchar(10),
	bloodgroup varchar(10),
	contact varchar(10),
	permanentaddress varchar(100),
	presentaddress varchar(100)
);

-----------------------------------------------------

create table appointment
(
	id int(5) primary key auto_increment,
	pfirstname varchar(30) not null,
	plastname varchar(30) not null,
	dateofapp varchar(20), 
	timeofapp varchar(10),
	pcontact varchar(10),
	pgender varchar(10),
	doctorname varchar(50) not null,
	dcontact varchar(10)	
);

[ dcontact = doctor contact, pfirstname = patient firstname, plastname = patient lastname, 
  dateofapp = date of appointment, timeofapp = time of appointment, pcontact = patient contact ]