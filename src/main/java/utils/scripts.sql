CREATE SCHEMA `exemplos`;

CREATE TABLE `exemplos`.`endereco` (
`id` INT NOT NULL AUTO_INCREMENT,
`rua` VARCHAR(75) NOT NULL,
`uf` CHAR(2) NOT NULL,
`cidade` VARCHAR(75) NOT NULL,
`numero` INTEGER NOT NULL,
`cep` VARCHAR(8) NOT NULL,
PRIMARY KEY (`id`));