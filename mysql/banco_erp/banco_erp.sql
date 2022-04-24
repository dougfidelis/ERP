-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema estoque
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema estoque
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `estoque` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
-- -----------------------------------------------------
-- Schema db_erp9
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_erp9
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_erp9` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `estoque` ;

-- -----------------------------------------------------
-- Table `estoque`.`mdf`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estoque`.`mdf` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(20) NOT NULL,
  `cor` VARCHAR(20) NOT NULL,
  `largura` INT NOT NULL,
  `altura` INT NOT NULL,
  `espessura` INT NOT NULL,
  `corte` VARCHAR(15) NOT NULL,
  UNIQUE INDEX `codigo` (`codigo` ASC))
ENGINE = MyISAM
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `db_erp9` ;

-- -----------------------------------------------------
-- Table `db_erp9`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp9`.`cliente` (
  `codigoCliente` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nomeCliente` VARCHAR(30) NOT NULL,
  `foneCliente` VARCHAR(30) NULL DEFAULT NULL,
  `emailCliente` VARCHAR(50) NULL DEFAULT NULL,
  `endCliente` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`codigoCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_erp9`.`orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp9`.`orcamento` (
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
    REFERENCES `db_erp9`.`cliente` (`codigoCliente`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_erp9`.`itensorcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp9`.`itensorcamento` (
  `codigoItem` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,
  `observacao` TEXT NULL DEFAULT NULL,
  `valor` DOUBLE NOT NULL,
  `quantidade` DOUBLE NULL DEFAULT NULL,
  `subTotal` DOUBLE NULL DEFAULT NULL,
  `codigoOrcamento` INT UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`codigoItem`),
  INDEX `fk_itens` (`codigoOrcamento` ASC) VISIBLE,
  CONSTRAINT `fk_itens`
    FOREIGN KEY (`codigoOrcamento`)
    REFERENCES `db_erp9`.`orcamento` (`codigoOrcamento`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_erp9`.`materiais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp9`.`materiais` (
  `codigoMaterial` INT UNSIGNED NOT NULL AUTO_INCREMENT,  
  `descricao` VARCHAR(30) NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valor` DOUBLE NOT NULL,
  `subTotal` DOUBLE NOT NULL,
  `codigoItem` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`codigoMaterial`),
  INDEX `fk_custos0_idx` (`codigoItem` ASC) VISIBLE,
  CONSTRAINT `fk_custos0`
    FOREIGN KEY (`codigoItem`)
    REFERENCES `db_erp9`.`itensorcamento` (`codigoItem`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_erp9`.`chapas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp9`.`chapas` (
  `codigo` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valor` DOUBLE NOT NULL,
  `subTotal` DOUBLE,
  `codigoMaterial` INT UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_chapa_idx` (`codigoMaterial` ASC) VISIBLE,
  CONSTRAINT `fk_chapa`
    FOREIGN KEY (`codigoMaterial`)
    REFERENCES `db_erp9`.`materiais` (`codigoMaterial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_erp9`.`corredicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp9`.`corredicas` (
  `codigo` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valor` DOUBLE NOT NULL,
  `subTotal` DOUBLE,
  `codigoMaterial` INT UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_corredica_idx` (`codigoMaterial` ASC) VISIBLE,
  CONSTRAINT `fk_corredica`
    FOREIGN KEY (`codigoMaterial`)
    REFERENCES `db_erp9`.`materiais` (`codigoMaterial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_erp9`.`custos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp9`.`custos` (
  `codigoCusto` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,  
  `quantidade` DOUBLE NOT NULL,
  `valor` DOUBLE NOT NULL,
  `subTotal` DOUBLE,
  `codigoItem` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`codigoCusto`),
  INDEX `fk_custos_idx` (`codigoItem` ASC) VISIBLE,
  CONSTRAINT `fk_custos`
    FOREIGN KEY (`codigoItem`)
    REFERENCES `db_erp9`.`itensorcamento` (`codigoItem`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_erp9`.`fitas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp9`.`fitas` (
 `codigo` INT NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valor` DOUBLE NOT NULL,
  `subTotal` DOUBLE,
  `codigoMaterial` INT UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_fita_idx` (`codigoMaterial` ASC) VISIBLE,
  CONSTRAINT `fk_fita`
    FOREIGN KEY (`codigoMaterial`)
    REFERENCES `db_erp9`.`materiais` (`codigoMaterial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_erp9`.`estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_erp9`.`estoque` (
  `codigoEstoque` INT NOT NULL AUTO_INCREMENT,
  `chapas` VARCHAR(45) NULL DEFAULT NULL,
  `codigo` INT NULL DEFAULT NULL,
  `fitas` VARCHAR(45) NULL DEFAULT NULL,
  `valor` INT NULL DEFAULT NULL,
  `corredicas` VARCHAR(45) NULL DEFAULT NULL,
  `codigo` INT NULL DEFAULT NULL,
  PRIMARY KEY (`codigoEstoque`),
  INDEX `fk_chapas_idx` (`codigo` ASC) VISIBLE,
  INDEX `fk_fitas_idx` (`valor` ASC) VISIBLE,
  INDEX `fk_corredicas_idx` (`codigo` ASC) VISIBLE,
  CONSTRAINT `fk_chapas`
    FOREIGN KEY (`codigo`)
    REFERENCES `db_erp9`.`chapas` (`codigo`),
  CONSTRAINT `fk_corredicas`
    FOREIGN KEY (`codigo`)
    REFERENCES `db_erp9`.`corredicas` (`codigo`),
  CONSTRAINT `fk_fitas`
    FOREIGN KEY (`valor`)
    REFERENCES `db_erp9`.`fitas` (`codigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
