--Create Table Client
CREATE TABLE public.client (
	id int8 NOT NULL,
	name varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	acess_token varchar(255) NULL,
	CONSTRAINT pk_id PRIMARY KEY(id),
);

--Create Table Loan
CREATE TABLE public.loan (
	id int8 NOT NULL,
	name varchar(255) NOT NULL,
	ts_created TIMESTAMP NOT NULL,
	value int8 NOT NULL,
	client_id int8 NULL,
	status varchar(30) NOT NULL,
	CONSTRAINT pk_id PRIMARY KEY(id),
	CONSTRAINT fk_client_id FOREIGN KEY(client_id) REFERENCES public.client(id)
);


--Populate Table Client
insert into client (id, name, email, password) values (1,'George Teste','email@financeiro.com','87d419c05e709d7a0583acc82e920901');
insert into client (id, name, email, password) values (2,'Pedro Teste','tqi@tqi.financeiro.com.br','82c2a4539aecc4188c70318d284849d9');

--Populate Table Loan
insert into loan (name, ts_created, value, client_id) values('Empréstimo X2',now(),58987.56,1);
insert into loan (name, ts_created, value, client_id) values('Empréstimo ZZ',now(),9877,1);
insert into loan (name, ts_created, value, client_id) values('Empréstimo XY2SA',now(),9877,2);