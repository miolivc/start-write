create table usuario(
	id integer not null,
	username varchar(20) unique not null,
	birthDate date not null,
	password varchar(20) not null,
	email varchar(30) primary key,
	name varchar(30) not null
);