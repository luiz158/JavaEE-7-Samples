SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `sample` DEFAULT CHARACTER SET latin1 ;
USE `sample` ;

-- -----------------------------------------------------
-- Table `sample`.`address`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`address` (
  `ID` BIGINT(20) NOT NULL ,
  `NAME` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`book`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`book` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `DESCRIPTION` VARCHAR(255) NULL DEFAULT NULL ,
  `ILLUSTRATIONS` TINYINT(1) NULL DEFAULT '0' ,
  `ISBN` VARCHAR(255) NULL DEFAULT NULL ,
  `NBOFPAGE` INT(11) NULL DEFAULT NULL ,
  `PRICE` FLOAT NULL DEFAULT NULL ,
  `TITLE` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`cd`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`cd` (
  `ID` BIGINT(20) NOT NULL ,
  `COVER` LONGBLOB NULL DEFAULT NULL ,
  `DESCRIPTION` VARCHAR(255) NULL DEFAULT NULL ,
  `PRICE` FLOAT NULL DEFAULT NULL ,
  `TITLE` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`cd_track`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`cd_track` (
  `CD_ID` BIGINT(20) NULL DEFAULT NULL ,
  `title` VARCHAR(255) NULL DEFAULT NULL ,
  `position` INT(11) NULL DEFAULT NULL ,
  INDEX `FK_cd_track_CD_ID` (`CD_ID` ASC) ,
  CONSTRAINT `FK_cd_track_CD_ID`
    FOREIGN KEY (`CD_ID` )
    REFERENCES `sample`.`cd` (`ID` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`city`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`city` (
  `ID` BIGINT(20) NOT NULL ,
  `CITY` VARCHAR(255) NULL DEFAULT NULL ,
  `STATE` VARCHAR(255) NULL DEFAULT NULL ,
  `ZIPCODE` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) ,
  CONSTRAINT `FK_city_ID`
    FOREIGN KEY (`ID` )
    REFERENCES `sample`.`address` (`ID` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`country`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`country` (
  `ID` BIGINT(20) NOT NULL ,
  `COUNTRY` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) ,
  CONSTRAINT `FK_country_ID`
    FOREIGN KEY (`ID` )
    REFERENCES `sample`.`address` (`ID` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`creditcard`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`creditcard` (
  `ID` BIGINT(20) NOT NULL ,
  `CONTROLNUMBER` INT(11) NULL DEFAULT NULL ,
  `CREDITCARDTYPE` ENUM('VISA','MASTER_CARD','AMERICAN_EXPRESS') NULL DEFAULT NULL ,
  `EXPIRYDATE` VARCHAR(255) NULL DEFAULT NULL ,
  `NUMBER` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`discount_code`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`discount_code` (
  `discount_code` CHAR(1) NOT NULL ,
  `rate` DECIMAL(4,2) NULL DEFAULT NULL ,
  PRIMARY KEY (`discount_code`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`micro_market`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`micro_market` (
  `zip_code` VARCHAR(10) NOT NULL ,
  `radius` DOUBLE NULL DEFAULT NULL ,
  `area_length` DOUBLE NULL DEFAULT NULL ,
  `area_width` DOUBLE NULL DEFAULT NULL ,
  PRIMARY KEY (`zip_code`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`customer` (
  `customer_id` INT(11) NOT NULL ,
  `discount_code` CHAR(1) NOT NULL ,
  `zip` VARCHAR(10) NOT NULL ,
  `name` VARCHAR(30) NULL DEFAULT NULL ,
  `addressline1` VARCHAR(30) NULL DEFAULT NULL ,
  `addressline2` VARCHAR(30) NULL DEFAULT NULL ,
  `city` VARCHAR(25) NULL DEFAULT NULL ,
  `state` CHAR(2) NULL DEFAULT NULL ,
  `phone` CHAR(12) NULL DEFAULT NULL ,
  `fax` CHAR(12) NULL DEFAULT NULL ,
  `email` VARCHAR(40) NULL DEFAULT NULL ,
  `credit_limit` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`customer_id`) ,
  INDEX `FK_customer_zip` (`zip` ASC) ,
  INDEX `FK_customer_discount_code` (`discount_code` ASC) ,
  CONSTRAINT `customer_ibfk_1`
    FOREIGN KEY (`discount_code` )
    REFERENCES `sample`.`discount_code` (`discount_code` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customer_ibfk_2`
    FOREIGN KEY (`zip` )
    REFERENCES `sample`.`micro_market` (`zip_code` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_customer_discount_code`
    FOREIGN KEY (`discount_code` )
    REFERENCES `sample`.`discount_code` (`discount_code` ),
  CONSTRAINT `FK_customer_zip`
    FOREIGN KEY (`zip` )
    REFERENCES `sample`.`micro_market` (`zip_code` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`customer_address`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`customer_address` (
  `Customer_customer_id` INT(11) NOT NULL ,
  `addresses_ID` BIGINT(20) NOT NULL ,
  PRIMARY KEY (`Customer_customer_id`, `addresses_ID`) ,
  INDEX `FK_customer_ADDRESS_addresses_ID` (`addresses_ID` ASC) ,
  CONSTRAINT `FK_customer_ADDRESS_addresses_ID`
    FOREIGN KEY (`addresses_ID` )
    REFERENCES `sample`.`address` (`ID` ),
  CONSTRAINT `FK_customer_ADDRESS_Customer_customer_id`
    FOREIGN KEY (`Customer_customer_id` )
    REFERENCES `sample`.`customer` (`customer_id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`usertable`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`usertable` (
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(145) NULL DEFAULT NULL ,
  PRIMARY KEY (`username`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`grouptable`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`grouptable` (
  `groupname` VARCHAR(45) NOT NULL ,
  `username` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`groupname`) ,
  INDEX `grouptable_username_FK` (`username` ASC) ,
  CONSTRAINT `grouptable_username_FK`
    FOREIGN KEY (`username` )
    REFERENCES `sample`.`usertable` (`username` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`item`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`item` (
  `ID` BIGINT(20) NOT NULL ,
  `DESCRIPTION` VARCHAR(255) NULL DEFAULT NULL ,
  `PRICE` FLOAT NULL DEFAULT NULL ,
  `TITLE` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`t_order`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`t_order` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `CREATIONDATE` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`order_line`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`order_line` (
  `ID` BIGINT(20) NOT NULL ,
  `ITEM` VARCHAR(255) NULL DEFAULT NULL ,
  `QUANTITY` INT(11) NULL DEFAULT NULL ,
  `UNITPRICE` DOUBLE NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`jnd_ord_line`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`jnd_ord_line` (
  `order_fk` BIGINT(20) NOT NULL ,
  `order_line_fk` BIGINT(20) NOT NULL ,
  PRIMARY KEY (`order_fk`, `order_line_fk`) ,
  INDEX `FK_jnd_ord_line_order_line_fk` (`order_line_fk` ASC) ,
  CONSTRAINT `FK_jnd_ord_line_order_fk`
    FOREIGN KEY (`order_fk` )
    REFERENCES `sample`.`t_order` (`ID` ),
  CONSTRAINT `FK_jnd_ord_line_order_line_fk`
    FOREIGN KEY (`order_line_fk` )
    REFERENCES `sample`.`order_line` (`ID` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`logger`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`logger` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `LOG` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 112
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`manufacturer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`manufacturer` (
  `manufacturer_id` INT(11) NOT NULL ,
  `name` VARCHAR(30) NULL DEFAULT NULL ,
  `addressline1` VARCHAR(30) NULL DEFAULT NULL ,
  `addressline2` VARCHAR(30) NULL DEFAULT NULL ,
  `city` VARCHAR(25) NULL DEFAULT NULL ,
  `state` CHAR(2) NULL DEFAULT NULL ,
  `zip` CHAR(10) NULL DEFAULT NULL ,
  `phone` VARCHAR(12) NULL DEFAULT NULL ,
  `fax` VARCHAR(12) NULL DEFAULT NULL ,
  `email` VARCHAR(40) NULL DEFAULT NULL ,
  `rep` VARCHAR(30) NULL DEFAULT NULL ,
  PRIMARY KEY (`manufacturer_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`news`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`news` (
  `TITLE` VARCHAR(255) NOT NULL ,
  `LANGUAGE` VARCHAR(255) NOT NULL ,
  `CONTENT` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`TITLE`, `LANGUAGE`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`product_code`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`product_code` (
  `prod_code` CHAR(2) NOT NULL ,
  `discount_code` CHAR(1) NOT NULL ,
  `description` VARCHAR(10) NULL DEFAULT NULL ,
  PRIMARY KEY (`prod_code`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`product` (
  `product_id` INT(11) NOT NULL ,
  `manufacturer_id` INT(11) NOT NULL ,
  `product_code` CHAR(2) NOT NULL ,
  `purchase_cost` DECIMAL(12,2) NULL DEFAULT NULL ,
  `quantity_on_hand` INT(11) NULL DEFAULT NULL ,
  `markup` DECIMAL(4,2) NULL DEFAULT NULL ,
  `available` VARCHAR(5) NULL DEFAULT NULL ,
  `description` VARCHAR(50) NULL DEFAULT NULL ,
  PRIMARY KEY (`product_id`) ,
  INDEX `FOREIGNKEY_manufacturer_id` (`manufacturer_id` ASC) ,
  INDEX `FOREIGNKEY_product_code` (`product_code` ASC) ,
  CONSTRAINT `product_ibfk_1`
    FOREIGN KEY (`manufacturer_id` )
    REFERENCES `sample`.`manufacturer` (`manufacturer_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_ibfk_2`
    FOREIGN KEY (`product_code` )
    REFERENCES `sample`.`product_code` (`prod_code` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`purchase_order`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`purchase_order` (
  `order_num` INT(11) NOT NULL ,
  `customer_id` INT(11) NOT NULL ,
  `product_id` INT(11) NOT NULL ,
  `quantity` SMALLINT(6) NULL DEFAULT NULL ,
  `shipping_cost` DECIMAL(12,2) NULL DEFAULT NULL ,
  `sales_date` DATE NULL DEFAULT NULL ,
  `shipping_date` DATE NULL DEFAULT NULL ,
  `freight_company` VARCHAR(30) NULL DEFAULT NULL ,
  PRIMARY KEY (`order_num`) ,
  INDEX `FOREIGNKEY_customer_id` (`customer_id` ASC) ,
  INDEX `FOREIGNKEY_product_id` (`product_id` ASC) ,
  CONSTRAINT `purchase_order_ibfk_1`
    FOREIGN KEY (`customer_id` )
    REFERENCES `sample`.`customer` (`customer_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `purchase_order_ibfk_2`
    FOREIGN KEY (`product_id` )
    REFERENCES `sample`.`product` (`product_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`sequence`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`sequence` (
  `SEQ_NAME` VARCHAR(50) NOT NULL ,
  `SEQ_COUNT` DECIMAL(38,0) NULL DEFAULT NULL ,
  PRIMARY KEY (`SEQ_NAME`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`student`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`student` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`student_address`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`student_address` (
  `Student_ID` BIGINT(20) NOT NULL ,
  `addresses_ID` BIGINT(20) NOT NULL ,
  PRIMARY KEY (`Student_ID`, `addresses_ID`) ,
  INDEX `FK_STUDENT_ADDRESS_addresses_ID` (`addresses_ID` ASC) ,
  CONSTRAINT `FK_STUDENT_ADDRESS_addresses_ID`
    FOREIGN KEY (`addresses_ID` )
    REFERENCES `sample`.`address` (`ID` ),
  CONSTRAINT `FK_STUDENT_ADDRESS_Student_ID`
    FOREIGN KEY (`Student_ID` )
    REFERENCES `sample`.`student` (`ID` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`t_address`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`t_address` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `CITY` VARCHAR(255) NULL DEFAULT NULL ,
  `COUNTRY` VARCHAR(255) NULL DEFAULT NULL ,
  `STATE` VARCHAR(255) NULL DEFAULT NULL ,
  `STREET1` VARCHAR(255) NULL DEFAULT NULL ,
  `STREET2` VARCHAR(255) NULL DEFAULT NULL ,
  `ZIPCODE` VARCHAR(255) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`t_member`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`t_member` (
  `ID` BIGINT(20) NOT NULL ,
  `EMAIL` VARCHAR(255) NULL DEFAULT NULL ,
  `first_name` VARCHAR(50) NOT NULL ,
  `last_name` VARCHAR(50) NOT NULL ,
  `phone_number` VARCHAR(15) NULL DEFAULT NULL ,
  `t_address_fk` BIGINT(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `FK_t_member_t_address_fk` (`t_address_fk` ASC) ,
  CONSTRAINT `FK_t_member_t_address_fk`
    FOREIGN KEY (`t_address_fk` )
    REFERENCES `sample`.`t_address` (`ID` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`tag`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`tag` (
  `Book_ID` BIGINT(20) NULL DEFAULT NULL ,
  `Value` VARCHAR(255) NULL DEFAULT NULL ,
  INDEX `FK_Tag_Book_ID` (`Book_ID` ASC) ,
  CONSTRAINT `FK_Tag_Book_ID`
    FOREIGN KEY (`Book_ID` )
    REFERENCES `sample`.`book` (`ID` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sample`.`track`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sample`.`track` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `DESCRIPTION` VARCHAR(255) NULL DEFAULT NULL ,
  `DURATION` FLOAT NULL DEFAULT NULL ,
  `TITLE` VARCHAR(255) NULL DEFAULT NULL ,
  `WAV` LONGBLOB NULL DEFAULT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
