-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssafyweb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafyweb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafyweb` DEFAULT CHARACTER SET utf8 ;
USE `ssafyweb` ;

-- -----------------------------------------------------
-- Table `ssafyweb`.`ssafy_member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ssafyweb`.`ssafy_member` ;

CREATE TABLE IF NOT EXISTS `ssafyweb`.`ssafy_member` (
  `userid` VARCHAR(16) NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `userpwd` VARCHAR(16) NOT NULL,
  `email` VARCHAR(50) NULL,
  `address` VARCHAR(100) NULL,
  `joindate` TIMESTAMP NULL DEFAULT current_timestamp,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB;

INSERT INTO ssafy_member (userid, username, userpwd, email, address)
VALUES('admin', '관리자', 'admin', 'admin@ssafy.com','서울시 역삼동');

INSERT INTO ssafy_member (userid, username, userpwd, email, address)
VALUES('ssafy', '김싸피', 'ssafy', 'ssafy@ssafy.com','대전시 덕명동');

commit;

-- -----------------------------------------------------
-- Table `ssafyweb`.`guestbook`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ssafyweb`.`guestbook` ;

CREATE TABLE IF NOT EXISTS `ssafyweb`.`guestbook` (
  `articleno` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NOT NULL,
  `subject` VARCHAR(100) NOT NULL,
  `content` VARCHAR(2000) NOT NULL,
  `regtime` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX `guestbook_userid_FK_idx` (`userid` ASC) VISIBLE,
  PRIMARY KEY (`articleno`),
  CONSTRAINT `guestbook_userid_FK`
    FOREIGN KEY (`userid`)
    REFERENCES `ssafyweb`.`ssafy_member` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
