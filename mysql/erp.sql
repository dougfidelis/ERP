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

select * from cliente;

create table orcamento(
	codigoOrcamento integer unsigned auto_increment,
	validade integer,
    entrega integer,
    rt double,
    imposto double,
    valor double not null,
    arquiteto varchar (50),
    emissao varchar (30) not null,
    formPgto varchar (100),
    situacao varchar (30),
    codigoCliente integer unsigned not null,
    primary key (codigoOrcamento),
    CONSTRAINT fk_codigoCliente FOREIGN KEY fk_codigoCliente(codigoCliente)
    REFERENCES cliente(codigoCliente) ON DELETE RESTRICT ON UPDATE RESTRICT)ENGINE = innodb;
    
    insert into orcamento (validade, entrega, rt, imposto, valor, arquiteto, emissao, formPgto, situacao, codigoCliente) 
    values (10, 10, 7, 11, 8952.30, "Cristiane", "19/04/2022", "1+4", "Aprovado", 4);
    
    update orcamento set entrega = 45 where codigoCliente = 4;
       
    select * from orcamento;
    
 create table materiais(
	codigoCusto integer unsigned auto_increment,
	descricao varchar(30) not null, 
    valor double not null,
	quantidade double not null,
	subTotal double not null,
    codigoOrcamento integer unsigned not null,    
    primary key (codigoCusto),
    CONSTRAINT fk_custos FOREIGN KEY fk_codigoOrcamento(codigoOrcamento)
    REFERENCES orcamento(codigoOrcamento) ON DELETE RESTRICT ON UPDATE RESTRICT)ENGINE = innodb;

create table itensOrcamento(
	codigoItem integer unsigned auto_increment,
	descricao varchar(30) not null, 
    valor double not null,
	quantidade double not null,
	subTotal double not null,
    codigoOrcamento integer unsigned not null,    
    primary key (codigoItem),
    CONSTRAINT fk_itens FOREIGN KEY fk_codigoOrcamento(codigoOrcamento)
    REFERENCES orcamento(codigoOrcamento) ON DELETE RESTRICT ON UPDATE RESTRICT)ENGINE = innodb;   
   
    create table custosOrcamento(
	codigoCusto integer unsigned auto_increment,
	descricao varchar(30) not null, 
    valor double not null,
	quantidade double not null,
	subTotal double not null,
    codigoOrcamento integer unsigned not null,    
    primary key (codigoCusto),
    CONSTRAINT fk_custos FOREIGN KEY fk_codigoOrcamento(codigoOrcamento)
    REFERENCES orcamento(codigoOrcamento) ON DELETE RESTRICT ON UPDATE RESTRICT)ENGINE = innodb;
    
   
    
    
    
    
    
    
    
    