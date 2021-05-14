-- 
-- Schema regedit_gateway
-- 
DROP SCHEMA IF EXISTS `regedit_gateway`;
CREATE SCHEMA `regedit_gateway` DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
USE `regedit_gateway`;
/*
-- 
-- USER ROLE
-- 
CREATE TABLE `regedit_gateway`.`is2_user_roles` (
  `ID` 	 	INT NOT NULL AUTO_INCREMENT,
  `ROLE` 	VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 
-- USER
-- 
CREATE TABLE `regedit_gateway`.`is2_users` (
  `ID` 			INT NOT NULL AUTO_INCREMENT,
  `EMAIL` 		VARCHAR(255) NULL,
  `NAME` 		VARCHAR(100) NULL,
  `SURNAME` 	VARCHAR(100) NULL,
  `PASSWORD` 	VARCHAR(500) NULL,
  `ROLE_ID` 	INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_is2_users_is2_user_roles` FOREIGN KEY (`ROLE_ID`)
        REFERENCES `is2_user_roles` (`ID`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
*/
-- 
-- CLASSIFICATION TABLES
-- 
CREATE TABLE regedit_gateway.is2_jwttoken (
    token character varying(200)
);