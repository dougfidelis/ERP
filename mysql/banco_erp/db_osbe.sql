-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_osbe
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_osbe
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_osbe` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `db_osbe` ;

-- -----------------------------------------------------
-- Table `db_osbe`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_osbe`.`cliente` (
  `codigoCliente` INT NOT NULL AUTO_INCREMENT,
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
-- Table `db_osbe`.`orcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_osbe`.`orcamento` (
  `codigoOrcamento` INT NOT NULL AUTO_INCREMENT,
  `validade` INT NULL DEFAULT NULL,
  `entrega` INT NULL DEFAULT NULL,
  `rt` DOUBLE NULL DEFAULT NULL,
  `imposto` DOUBLE NULL DEFAULT NULL,
  `valor` DOUBLE NOT NULL,
  `arquiteto` VARCHAR(50) NULL DEFAULT NULL,
  `emissao` VARCHAR(30) NOT NULL,
  `formPgto` VARCHAR(100) NULL DEFAULT NULL,
  `situacao` VARCHAR(30) NULL DEFAULT NULL,
  `codigoCliente` INT NOT NULL,
  PRIMARY KEY (`codigoOrcamento`),
  INDEX `fk_codigoCliente` (`codigoCliente` ASC) VISIBLE,
  CONSTRAINT `fk_codigoCliente`
    FOREIGN KEY (`codigoCliente`)
    REFERENCES `db_osbe`.`cliente` (`codigoCliente`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_osbe`.`itensorcamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_osbe`.`itensorcamento` (
  `codigoItem` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,
  `observacao` TEXT NULL DEFAULT NULL,
  `valor` DOUBLE NOT NULL,
  `quantidade` DOUBLE NULL DEFAULT NULL,
  `subTotal` DOUBLE NULL DEFAULT NULL,
  `codigoOrcamento` INT NULL DEFAULT NULL,
  PRIMARY KEY (`codigoItem`),
  INDEX `fk_itens` (`codigoOrcamento` ASC) VISIBLE,
  CONSTRAINT `fk_itens`
    FOREIGN KEY (`codigoOrcamento`)
    REFERENCES `db_osbe`.`orcamento` (`codigoOrcamento`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_osbe`.`materiais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_osbe`.`materiais` (
  `codigoMaterial` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `subTotal` DOUBLE NOT NULL,
  `codigoItem` INT NOT NULL,
  PRIMARY KEY (`codigoMaterial`),
  INDEX `fk_custos0_idx` (`codigoItem` ASC) VISIBLE,
  CONSTRAINT `fk_custos0`
    FOREIGN KEY (`codigoItem`)
    REFERENCES `db_osbe`.`itensorcamento` (`codigoItem`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_osbe`.`chapas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_osbe`.`chapas` (
  `cd_chapa` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valor` DOUBLE NOT NULL,
  `subTotal` DOUBLE NULL,
  `codigoMaterial` INT NULL DEFAULT NULL,
  PRIMARY KEY (`cd_chapa`),
  INDEX `fk_chapa_idx` (`codigoMaterial` ASC) VISIBLE,
  CONSTRAINT `fk_chapa`
    FOREIGN KEY (`codigoMaterial`)
    REFERENCES `db_osbe`.`materiais` (`codigoMaterial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_osbe`.`corredicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_osbe`.`corredicas` (
  `cd_corredica` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valor` DOUBLE NOT NULL,
  `subTotal` DOUBLE NULL,
  `codigoMaterial` INT NULL DEFAULT NULL,
  PRIMARY KEY (`cd_corredica`),
  INDEX `fk_corredica_idx` (`codigoMaterial` ASC) VISIBLE,
  CONSTRAINT `fk_corredica`
    FOREIGN KEY (`codigoMaterial`)
    REFERENCES `db_osbe`.`materiais` (`codigoMaterial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_osbe`.`custos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_osbe`.`custos` (
  `codigoCusto` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(30) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `subTotal` DOUBLE NOT NULL,
  `codigoItem` INT NOT NULL,
  PRIMARY KEY (`codigoCusto`),
  INDEX `fk_custos_idx` (`codigoItem` ASC) VISIBLE,
  CONSTRAINT `fk_custos`
    FOREIGN KEY (`codigoItem`)
    REFERENCES `db_osbe`.`itensorcamento` (`codigoItem`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_osbe`.`fitas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_osbe`.`fitas` (
  `cd_fita` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `quantidade` DOUBLE NOT NULL,
  `valor` DOUBLE NOT NULL,
  `subTotal` DOUBLE NULL,
  `codigoMaterial` INT NULL DEFAULT NULL,
  PRIMARY KEY (`cd_fita`),
  INDEX `fk_fita_idx` (`codigoMaterial` ASC) VISIBLE,
  CONSTRAINT `fk_fita`
    FOREIGN KEY (`codigoMaterial`)
    REFERENCES `db_osbe`.`materiais` (`codigoMaterial`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_osbe`.`estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_osbe`.`estoque` (
  `codigoEstoque` INT NOT NULL AUTO_INCREMENT,
  `chapas` VARCHAR(45) NULL DEFAULT NULL,
  `cd_chapas` INT NULL DEFAULT NULL,
  `fitas` VARCHAR(45) NULL DEFAULT NULL,
  `cd_fitas` INT NULL DEFAULT NULL,
  `corredicas` VARCHAR(45) NULL DEFAULT NULL,
  `cd_corredicas` INT NULL DEFAULT NULL,
  PRIMARY KEY (`codigoEstoque`),
  INDEX `fk_chapas_idx` (`cd_chapas` ASC) VISIBLE,
  INDEX `fk_fitas_idx` (`cd_fitas` ASC) VISIBLE,
  INDEX `fk_corredicas_idx` (`cd_corredicas` ASC) VISIBLE,
  CONSTRAINT `fk_chapas`
    FOREIGN KEY (`cd_chapas`)
    REFERENCES `db_osbe`.`chapas` (`cd_chapa`),
  CONSTRAINT `fk_corredicas`
    FOREIGN KEY (`cd_corredicas`)
    REFERENCES `db_osbe`.`corredicas` (`cd_corredica`),
  CONSTRAINT `fk_fitas`
    FOREIGN KEY (`cd_fitas`)
    REFERENCES `db_osbe`.`fitas` (`cd_fita`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `db_osbe`.`mdf`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_osbe`.`mdf` (
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
