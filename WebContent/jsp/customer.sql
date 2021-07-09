drop table customer if exists;

create table customer(
id int auto_increment primary key,
login varcher(100)not null unique,
passwor varcher(100)not null);

insert intocustomer values(null,"takeshi","2");