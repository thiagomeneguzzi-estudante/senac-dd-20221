CREATE SCHEMA `exemplos`;

CREATE TABLE exemplos.cliente (
      id int auto_increment primary key,
      nome varchar(75)  not null,
      cpf varchar(11) not null,
      idEndereco int,
      foreign key (idEndereco) references exemplos.telefone (id)
);

CREATE TABLE `exemplos`.`endereco` (
`id` INT NOT NULL AUTO_INCREMENT,
`rua` VARCHAR(75) NOT NULL,
`uf` CHAR(2) NOT NULL,
`cidade` VARCHAR(75) NOT NULL,
`numero` INTEGER NOT NULL,
`cep` VARCHAR(8) NOT NULL,
PRIMARY KEY (`id`));

create table exemplos.telefone
(
    id     int auto_increment
        primary key,
    ddd    varchar(2)  not null,
    numero varchar(10) not null,
    tipo   int         not null,
    ativo  tinyint(1)  not null,
    ddi    varchar(4)  not null
);

create table exemplos.linha_telefonica
(
    id              int auto_increment
        primary key,
    idTelefone      int      not null,
    idCliente       int      null,
    dataAtivacao    datetime null,
    dataDesativacao datetime null,
    constraint fk_idTelefone
        foreign key (idTelefone) references exemplos.telefone (id)
);
