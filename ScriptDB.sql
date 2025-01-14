create database clientDB;

create table client
(
id bigint auto_increment primary key,
nombres varchar(255) not null,
apellidos varchar(255) not null,
dni varchar(8) unique not null,
email varchar(255) not null
);

create database accountDB;

create table account
(
id bigint auto_increment primary key,
nro_cuenta varchar(14) unique not null,
saldo double not null,
tipo_cuenta int not null,
id_cliente bigint not null,
status int not null
);

create table transactionlog
(
id bigint auto_increment primary key,
id_cuenta bigint not null,
fecha date not null,
monto double not null,
tipo_trx varchar(100) not null
);
