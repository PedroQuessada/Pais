-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema vendas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema vendas
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `pais`;

CREATE SCHEMA IF NOT EXISTS `pais` DEFAULT CHARACTER SET utf8 ;
USE `pais` ;

-- -----------------------------------------------------
-- Table `vendas`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pais` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `populacao` BIGINT(100) NOT NULL,
  `area`  DECIMAL(15,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


USE `pais` ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


SELECT * FROM Pais;

/*INSERT INTO pais (nome, populacao, area) VALUES('Brasil', 200000000, 100);
INSERT INTO pais (nome, populacao, area) VALUES('Brasil', 200000000, 123);
INSERT INTO pais (nome, populacao, area) VALUES('Brasil', 200000000, 123);
INSERT INTO pais (nome, populacao, area) VALUES('Brasill', 500000000, 123);
Select * from pais;
SELECT  id, nome, populacao, area  from pais where populacao = (select Max(populacao) from pais);
SELECT Max(populacao),id, nome, area  from pais ;
SELECT  id, nome, populacao, area  from pais where area = (select 	Min(area) from pais);*/