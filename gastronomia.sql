create database gastronomia;
use gastronomia;
create table Atributo (
	IdAtributo bigint(20) auto_increment primary key,
	Multiplicador bigint(20),
	Nome varchar(255),
	Obrigatorio bit(1) not null,
	Status bit(1) not null,
	Unidade varchar(255),
	Ordem bigint(20)
);
create table GrupoReceita (
	IdGrupo bigint(20) auto_increment primary key,
	CustoPorcao double,
	Nome varchar(255),
	Status bit(1) not null
);
create table Usuario (
	IdUsuario bigint(20) auto_increment primary key,
	Cpf varchar(255),
	Email varchar(255),
	Matricula varchar(255),
	Nome varchar(255),
	Senha varchar(255),
	Status bit(1) not null,
	Tipo varchar(255)
);
create table Ingrediente_Atributo (
	Valor varchar(255),
	IdAtributo bigint(20),
	IdIngrediente bigint(20),
	constraint pk_Ingrediente_Atributo primary key (IdAtributo, IdIngrediente)
);
create table Receita (
	IdReceita bigint(20) auto_increment primary key,
	Imagem varchar(255) not null,
	Nome varchar(255),
	Passos longtext not null,
	Rendimento double not null,
	Status bit(1) not null,
	Tempo varchar(255) not null,
	Tipo int(11) not null,
	GrupoReceita bigint(20) not null,
	IdUsuario bigint(20) not null
);
create table ReceitaUsuario (
	IdReceita bigint(20),
	IdUsuario bigint(20),
	constraint pk_ReceitaUsuario primary key (IdReceita, IdUsuario)
);
create table Ingrediente (
	IdIngrediente bigint(20) auto_increment primary key,
	Nome varchar(255),
	Origem varchar(255),
	Status bit(1) not null,
	Tipo varchar(255),
	IdUsuario bigint(20) not null
);
create table ReceitaIngrediente (
	CustoKg double,
	PesoG double,
	IdReceita bigint(20),
	IdIngrediente bigint(20),
	constraint pk_ReceitaIngrediente primary key (IdReceita, IdIngrediente)
);