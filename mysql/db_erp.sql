-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema db_erp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_erp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_erp1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema estoque
-- -----------------------------------------------------
USE `db_erp1` ;

-- -----------------------------------------------------
-- Table `db_erp`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp1`.`cliente` (
  `codigoCliente` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(30) NOT NULL,
  `foneCliente` VARCHAR(30) NULL DEFAULT NULL,
  `emailCliente` VARCHAR(50) NULL DEFAULT NULL,
  `endCliente` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`codigoCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

SELECT * FROM cliente;
DELETE FROM cliente WHERE codigoCliente = 17;


-- -----------------------------------------------------
-- Table `db_erp`.`orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp1`.`orcamento` (
  `codigoOrcamento` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `validade` INT NULL DEFAULT NULL,
  `entrega` INT NULL DEFAULT NULL,
  `rt` DOUBLE NULL DEFAULT NULL,
  `imposto` DOUBLE NULL DEFAULT NULL,
  `valor` DOUBLE NOT NULL,
  `arquiteto` VARCHAR(50) NULL DEFAULT NULL,
  `emissao` VARCHAR(30) NOT NULL,
  `formPgto` VARCHAR(100) NULL DEFAULT NULL,
  `situacao` VARCHAR(30) NULL DEFAULT NULL,
  `codigoCliente` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`codigoOrcamento`),
  INDEX `fk_codigoCliente` (`codigoCliente` ASC) VISIBLE,
  CONSTRAINT `fk_codigoCliente`
    FOREIGN KEY (`codigoCliente`)
    REFERENCES `db_erp1`.`cliente` (`codigoCliente`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `orcamento` 
	(`codigoOrcamento`, `validade`, `entrega`, `rt`, `imposto`, `valor`, `arquiteto`, `emissao`, `formPgto`, `situacao`, `codigoCliente`) 
    VALUES (NULL, '10', '45', '7', '6', '1250,53', 'Dayana', '20/04/2022', '1+4', 'Aprovado', 19);
    


-- -----------------------------------------------------
-- Table `db_erp`.`custosorcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp1`.`custosorcamento` (
  `codigoCusto` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `subTotal` DOUBLE NOT NULL,
  `codigoOrcamento` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`codigoCusto`),
  INDEX `fk_custos` (`codigoOrcamento` ASC) VISIBLE,
  CONSTRAINT `fk_custos`
    FOREIGN KEY (`codigoOrcamento`)
    REFERENCES `db_erp`.`orcamento` (`codigoOrcamento`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_erp`.`itensorcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp1`.`itensorcamento` (
  `codigoItem` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `subTotal` DOUBLE NOT NULL,
  `codigoOrcamento` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`codigoItem`),
  INDEX `fk_itens` (`codigoOrcamento` ASC) VISIBLE,
  CONSTRAINT `fk_itens`
    FOREIGN KEY (`codigoOrcamento`)
    REFERENCES `db_erp1`.`orcamento` (`codigoOrcamento`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `itensorcamento` (`codigoItem`, `descricao`, `observacao`, `valor`, `quantidade`, `subTotal`, `codigoOrcamento`) 
VALUES (NULL, 'Criado Mudo', 'Criado mudo 40x40 com 2 gavetas', '680', '', '', NULL);

select * from itensorcamento;

delete from itensorcamento where codigoitem = 2;


-- -----------------------------------------------------
-- Table `db_erp`.`chapas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp1`.`chapas` (
  `cd_chapa` INT NOT NULL,
  `ds_chapa` VARCHAR(45) NOT NULL,
  `qtd_chapa` DOUBLE NOT NULL,
  `valor_chapa` DOUBLE NOT NULL,
  PRIMARY KEY (`cd_chapa`))
ENGINE = InnoDB;

INSERT INTO `chapas` (`cd_chapa`, `ds_chapa`, `qtd_chapa`, `valor_chapa`) VALUES (1, 'MDF Branco 18', '50', '235');


-- -----------------------------------------------------
-- Table `db_erp`.`fitas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp1`.`fitas` (
  `cd_fita` INT NOT NULL,
  `ds_fita` VARCHAR(45) NOT NULL,
  `qtd_fita` DOUBLE NOT NULL,
  `valor_fita` DOUBLE NOT NULL,
  PRIMARY KEY (`cd_fita`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_erp`.`corredicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp1`.`corredicas` (
  `cd_corredica` INT NOT NULL,
  `ds_corredica` VARCHAR(45) NOT NULL,
  `qtd_corredica` DOUBLE NOT NULL,
  `valor_corredica` DOUBLE NOT NULL,
  PRIMARY KEY (`cd_corredica`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_erp`.`estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp1`.`estoque` (
  `codigoEstoque` INT NOT NULL,
  `chapas` VARCHAR(45) NULL,
  `cd_chapas` INT NULL,
  `fitas` VARCHAR(45) NULL,
  `cd_fitas` INT NULL,
  `corredicas` VARCHAR(45) NULL,
  `cd_corredicas` INT NULL,
  PRIMARY KEY (`codigoEstoque`),
  INDEX `fk_chapas_idx` (`cd_chapas` ASC) VISIBLE,
  INDEX `fk_fitas_idx` (`cd_fitas` ASC) VISIBLE,
  INDEX `fk_corredicas_idx` (`cd_corredicas` ASC) VISIBLE,
  CONSTRAINT `fk_chapas`
    FOREIGN KEY (`cd_chapas`)
    REFERENCES `db_erp1`.`chapas` (`cd_chapa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fitas`
    FOREIGN KEY (`cd_fitas`)
    REFERENCES `db_erp1`.`fitas` (`cd_fita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_corredicas`
    FOREIGN KEY (`cd_corredicas`)
    REFERENCES `db_erp`.`corredicas` (`cd_corredica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

CREATE TABLE IF NOT EXISTS `db_erp1`.`mdf` (
  `cd_chapa` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `ds_chapa` VARCHAR(45) NOT NULL,
  `qtd_chapa` DOUBLE NOT NULL,
  `valor_chapa` DOUBLE NOT NULL,
  PRIMARY KEY (`cd_chapa`));
  
  INSERT INTO `mdf` (`cd_chapa`, `ds_chapa`, `qtd_chapa`, `valor_chapa`) VALUES (null, 'MDF Branco 18', '50', '235');
