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
	codigoOrcamento integer unsigned not null,
	validade integer,
    entrega integer,
    rt double,
    imposto double,
    valor double not null,
    arquiteto varchar (50),
    emissao varchar (30) not null,
    formPagto varchar (100),
    situacao varchar (30),        
    primary key (codigoOrcamento),
    CONSTRAINT fk_codigoCliente FOREIGN KEY fk_codigoCliente(codigoCliente)
    REFERENCES cliente(codigoCliente) ON DELETE RESTRICT ON UPDATE RESTRICT)ENGINE = innodb;

create table itensOrcamento(
	codigoItem integer unsigned not null,
	descricao varchar(30) not null, 
    valor double not null,
	quantidade double not null,
	subTotal double not null,
    codigoOrcamento integer unsigned,
    primary key (codigoItem),
    CONSTRAINT fk_codigoOrçamento FOREIGN KEY fk_codigoOrcamento(codigoOrcamento)
    REFERENCES orcamento(codigoOrcamento) ON DELETE RESTRICT ON UPDATE RESTRICT)ENGINE = innodb;
    
    
    
    
    
    