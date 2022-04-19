create database erp;

use erp;

create table cliente(
	codigoCliente integer unsigned auto_increment,
	nomeCliente varchar(30) not null,
    foneCliente varchar(30) ,
    emailCliente varchar(50) ,
    endCliente varchar(30) ,    
    primary key (codigoCliente)
)ENGINE = innodb;

create table orcamento(
	numeroOrcamento integer unsigned auto_increment,
	nomeCliente varchar(30) not null,
    foneCliente varchar(30),
    emailCliente varchar(50),
    endCliente varchar(30),
    dataCadastro varchar(30),    
    primary key (codigoCliente)
)ENGINE = innodb;

create table materialOrcamento(
	codigoMaterial integer unsigned auto_increment,
	descricao varchar(30) not null, 
    valor double not null,
	quantidade double not null,
	subTotal double not null,
    codigoCliente integer unsigned,
    primary key (codigoMaterial),
    CONSTRAINT fk_codigoCliente FOREIGN KEY fk_codigoCliente(codigoCliente)
    REFERENCES orcamento(codigoCliente) ON DELETE RESTRICT ON UPDATE RESTRICT)ENGINE = innodb;
    
    
    
    
    
    