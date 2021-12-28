create database dbagenda;
use dbagenda;
create table contatos(
	idcon int primary key auto_increment,
    nome varchar(50) not null, 
    fone varchar(15) not null,
    email varchar(50)
);

/* CRUD create*/
insert into contatos (nome, fone, email) values ("Jose", "9999-8888", "jose@mail.com");

/* CRUD read*/
select * from contatos;
select * from contatos order by nome;
select * from contatos where idcon = 4;

/* CRUD update*/
update contatos set nome = ?, fone = ?, email = ? where idcon = ?;

/* CRUD delete*/