SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `orienteering` ;
CREATE SCHEMA IF NOT EXISTS `orienteering` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `orienteering` ;

-- -----------------------------------------------------
-- Table `orienteering`.`clubs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`clubs` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`clubs` (
  `idclub` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(128) NULL,
  `agent_name` VARCHAR(45) NULL,
  `agent_surname` VARCHAR(45) NULL,
  `club_number` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  PRIMARY KEY (`idclub`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orienteering`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`users` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`users` (
  `iduser` INT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `type` VARCHAR(10) NULL,
  `idclub` INT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  PRIMARY KEY (`iduser`),
  INDEX `fk_user_1_idx` (`idclub` ASC),
  CONSTRAINT `fk_user_1`
    FOREIGN KEY (`idclub`)
    REFERENCES `orienteering`.`clubs` (`idclub`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `orienteering`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`person` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`person` (
  `idclub` INT NOT NULL,
  `address` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `email` VARCHAR(255) NULL,
  `phone_number` VARCHAR(45) NULL,
  PRIMARY KEY (`idclub`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orienteering`.`categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`categories` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`categories` (
  `idcategory` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`idcategory`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orienteering`.`competitors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`competitors` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`competitors` (
  `idcompetitor` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `licence_number` VARCHAR(5) NULL,
  `chip_number` INT NULL,
  `idclub` INT NOT NULL,
  `birth_year` INT NULL,
  `gender` CHAR(1) NULL,
  `category` INT NULL,
  PRIMARY KEY (`idcompetitor`),
  UNIQUE INDEX `chip_number_UNIQUE` (`chip_number` ASC),
  INDEX `fk_competitors_2_idx` (`category` ASC),
  INDEX `fk_competitors_1_idx` (`idclub` ASC),
  CONSTRAINT `fk_competitors_1`
    FOREIGN KEY (`idclub`)
    REFERENCES `orienteering`.`clubs` (`idclub`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_competitors_2`
    FOREIGN KEY (`category`)
    REFERENCES `orienteering`.`categories` (`idcategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orienteering`.`acomodations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`acomodations` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`acomodations` (
  `idacomodation` INT NOT NULL AUTO_INCREMENT,
  `adress` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  `places` INT NULL,
  PRIMARY KEY (`idacomodation`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orienteering`.`caterings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`caterings` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`caterings` (
  `idacatering` INT NOT NULL AUTO_INCREMENT,
  `adress` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`idacatering`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orienteering`.`acomodation_avaliabilities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`acomodation_avaliabilities` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`acomodation_avaliabilities` (
  `idreservations_options` INT NOT NULL AUTO_INCREMENT,
  `acomodationid` INT NULL,
  `date` DATE NULL,
  `price` FLOAT NULL,
  PRIMARY KEY (`idreservations_options`),
  INDEX `fk_acomodation_avaliabilities_1_idx` (`acomodationid` ASC),
  CONSTRAINT `fk_acomodation_avaliabilities_1`
    FOREIGN KEY (`acomodationid`)
    REFERENCES `orienteering`.`acomodations` (`idacomodation`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orienteering`.`catering_avaliabilities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`catering_avaliabilities` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`catering_avaliabilities` (
  `idreservations_options` INT NOT NULL AUTO_INCREMENT,
  `cateringid` INT NULL,
  `date` DATE NULL,
  `meal_time` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `price` FLOAT NULL,
  PRIMARY KEY (`idreservations_options`),
  INDEX `fk_catering_avaliabilities_1_idx` (`cateringid` ASC),
  CONSTRAINT `fk_catering_avaliabilities_1`
    FOREIGN KEY (`cateringid`)
    REFERENCES `orienteering`.`caterings` (`idacatering`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orienteering`.`competiton_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`competiton_info` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`competiton_info` (
  `idcompetiton_info` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(255) NULL,
  `begin` DATE NULL,
  `end` DATE NULL,
  `entry_fee` FLOAT NULL,
  `overdue_entry_fee` FLOAT NULL,
  `chip_borrow_fee` FLOAT NULL,
  `chip_lost_fee` FLOAT NULL,
  `aplication_deadline` DATE NULL,
  `aplication_start` DATE NULL,
  PRIMARY KEY (`idcompetiton_info`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orienteering`.`catering_reservations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`catering_reservations` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`catering_reservations` (
  `idcatering_reservations` INT NOT NULL AUTO_INCREMENT,
  `cateriing_option` INT NOT NULL,
  `competitor` INT NOT NULL,
  PRIMARY KEY (`idcatering_reservations`),
  INDEX `fk_catering_reservations_1_idx` (`cateriing_option` ASC),
  INDEX `fk_catering_reservations_2_idx` (`competitor` ASC),
  CONSTRAINT `fk_catering_reservations_1`
    FOREIGN KEY (`cateriing_option`)
    REFERENCES `orienteering`.`catering_avaliabilities` (`idreservations_options`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_catering_reservations_2`
    FOREIGN KEY (`competitor`)
    REFERENCES `orienteering`.`competitors` (`idcompetitor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orienteering`.`acomodation_reservations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orienteering`.`acomodation_reservations` ;

CREATE TABLE IF NOT EXISTS `orienteering`.`acomodation_reservations` (
  `idacomodation_reservations` INT NOT NULL AUTO_INCREMENT,
  `acomodation_option` INT NOT NULL,
  `competitor` INT NOT NULL,
  PRIMARY KEY (`idacomodation_reservations`),
  INDEX `fk_acomodation_reservations_1_idx` (`acomodation_option` ASC),
  INDEX `fk_acomodation_reservations_2_idx` (`competitor` ASC),
  CONSTRAINT `fk_acomodation_reservations_1`
    FOREIGN KEY (`acomodation_option`)
    REFERENCES `orienteering`.`acomodation_avaliabilities` (`idreservations_options`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_acomodation_reservations_2`
    FOREIGN KEY (`competitor`)
    REFERENCES `orienteering`.`competitors` (`idcompetitor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
