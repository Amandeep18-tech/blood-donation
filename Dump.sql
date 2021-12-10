-- MySQL Script generated by MySQL Workbench
-- Thu Dec  9 07:36:27 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema CSCI5308_16_DEVINT
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CSCI5308_16_DEVINT
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CSCI5308_16_DEVINT` DEFAULT CHARACTER SET utf8mb4 ;
USE `CSCI5308_16_DEVINT` ;

-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`Person` (
  `person_id` VARCHAR(36) NOT NULL,
  `person_first_name` VARCHAR(45) NULL DEFAULT NULL,
  `person_last_name` VARCHAR(45) NULL DEFAULT NULL,
  `contact_number` VARCHAR(45) NULL DEFAULT NULL,
  `blood_group` VARCHAR(45) NULL DEFAULT NULL,
  `pin_code` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`person_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`blood_donated_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`blood_donated_details` (
  `id` VARCHAR(45) NOT NULL,
  `donor_id` VARCHAR(45) NULL DEFAULT NULL,
  `blood_group` VARCHAR(45) NULL DEFAULT NULL,
  `donated_at` VARCHAR(45) NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `org_id` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`blood_donation_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`blood_donation_details` (
  `id` VARCHAR(45) NOT NULL,
  `slot_number` INT(11) NULL DEFAULT NULL,
  `donation_time` TIME NULL DEFAULT NULL,
  `organisation_id` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`blood_donation_details_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`blood_donation_details_history` (
  `id` VARCHAR(45) NOT NULL,
  `donor_id` VARCHAR(45) NULL DEFAULT NULL,
  `slot_date` DATE NULL DEFAULT NULL,
  `blood_group` VARCHAR(45) NULL DEFAULT NULL,
  `slot_id` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`blood_request_organisation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`blood_request_organisation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `org_id` VARCHAR(45) NULL DEFAULT NULL,
  `receiver_org_id` VARCHAR(45) NULL DEFAULT NULL,
  `units_required` INT(11) NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `blood_group` VARCHAR(45) NULL DEFAULT NULL,
  `timestamp` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`donor_medical_records`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`donor_medical_records` (
  `id` VARCHAR(45) NOT NULL,
  `donor_id` VARCHAR(45) NULL DEFAULT NULL,
  `hepatitis_B` TINYINT(4) NULL DEFAULT NULL,
  `hepatitis_C` TINYINT(4) NULL DEFAULT NULL,
  `HIV_flag` TINYINT(4) NULL DEFAULT NULL,
  `hemoglobin_level` INT(11) NULL DEFAULT NULL,
  `hemochromatosis` TINYINT(4) NULL DEFAULT NULL,
  `rbc_count` INT(11) NULL DEFAULT NULL,
  `platelet_count` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`financial_donation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`financial_donation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `donor_id` VARCHAR(45) NULL DEFAULT NULL,
  `amount` VARCHAR(45) NULL DEFAULT NULL,
  `donation_type` VARCHAR(45) NULL DEFAULT NULL,
  `trans_ref_number` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 42
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`location_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`location_details` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `pin_code` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`location_distance_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`location_distance_details` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `pin_code1` VARCHAR(45) NULL DEFAULT NULL,
  `pin_code2` VARCHAR(45) NULL DEFAULT NULL,
  `distance` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 101
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`medical_appointment_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`medical_appointment_details` (
  `medical_appointment_details_id` VARCHAR(36) NOT NULL,
  `patient_id` VARCHAR(36) NULL DEFAULT NULL,
  `slot_id` VARCHAR(36) NULL DEFAULT NULL,
  `slot_date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`medical_appointment_details_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`medical_appointment_master`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`medical_appointment_master` (
  `medical_appointment_master_id` VARCHAR(36) NOT NULL,
  `organisation_id` VARCHAR(36) NULL DEFAULT NULL,
  `slot_number` VARCHAR(45) NULL DEFAULT NULL,
  `slot_start_time` TIME NULL DEFAULT NULL,
  `slot_end_time` TIME NULL DEFAULT NULL,
  PRIMARY KEY (`medical_appointment_master_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`organisation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`organisation` (
  `organisation_id` VARCHAR(36) NOT NULL,
  `organisation_name` VARCHAR(45) NULL DEFAULT NULL,
  `location` VARCHAR(255) NULL DEFAULT NULL,
  `organisation_type` INT(11) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `slots_available` VARCHAR(45) NULL DEFAULT NULL,
  `pin_code` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`organisation_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`patient_blood_request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`patient_blood_request` (
  `id` VARCHAR(45) NOT NULL,
  `patient_id` VARCHAR(45) NULL DEFAULT NULL,
  `priority` TINYINT(4) NULL DEFAULT NULL,
  `appointment_date` DATE NULL DEFAULT NULL,
  `appointment_time` TIME NULL DEFAULT NULL,
  `status` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`patient_personal_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`patient_personal_information` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `patient_name` TEXT NOT NULL,
  `date_of_birth` TEXT NULL DEFAULT NULL,
  `age` INT(11) NOT NULL,
  `address` TEXT NOT NULL,
  `contact_number` TEXT NOT NULL,
  `email_id` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 71
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`patient_login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`patient_login` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `patient_id` INT(11) NOT NULL,
  `patient_name` TEXT NOT NULL,
  `patient_email_id` TEXT NOT NULL,
  `patient_username` TEXT NOT NULL,
  `patient_password` TEXT NOT NULL,
  `pin_code` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `patient_login_ibfk_1` (`patient_id` ASC) VISIBLE,
  CONSTRAINT `patient_login_ibfk_1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `CSCI5308_16_DEVINT`.`patient_personal_information` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`patient_medical_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`patient_medical_information` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `patient_id` INT(11) NOT NULL,
  `blood_group` TEXT NOT NULL,
  `has_hepatitis_B` INT(11) NOT NULL,
  `has_hepatitis_C` INT(11) NOT NULL,
  `has_HIV` INT(11) NOT NULL,
  `has_hemochromatosis` INT(11) NOT NULL,
  `hemoglobin_level` INT(11) NOT NULL,
  `rbc_count` INT(11) NOT NULL,
  `platelet_count` INT(11) NOT NULL,
  `current_location` TEXT NOT NULL,
  `dr_reference` TEXT NOT NULL,
  `requirement_reason` TEXT NOT NULL,
  `priority` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `patient_medical_information_ibfk_1` (`patient_id` ASC) VISIBLE,
  CONSTRAINT `patient_medical_information_ibfk_1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `CSCI5308_16_DEVINT`.`patient_personal_information` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`patient_request_mapping`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`patient_request_mapping` (
  `id` VARCHAR(45) NOT NULL,
  `patient_blood_request_id` VARCHAR(45) NULL DEFAULT NULL,
  `donor_or_organisation_id` VARCHAR(45) NULL DEFAULT NULL,
  `accept_flag` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`pending_financial_donations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`pending_financial_donations` (
  `id` INT(11) NOT NULL,
  `amount` VARCHAR(45) NULL DEFAULT NULL,
  `tp_ref_num` VARCHAR(45) NULL DEFAULT NULL,
  `donation_type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`seq_num_master`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`seq_num_master` (
  `seq_name` VARCHAR(10) NOT NULL,
  `seq_no` INT(11) NULL DEFAULT NULL,
  `seq_pattern` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`seq_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`stored_messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`stored_messages` (
  `msg_id` BIGINT(20) NULL DEFAULT NULL,
  `msg_value` TEXT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`survey_master`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`survey_master` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `survey_title` TEXT NOT NULL,
  `survey_desc` TEXT NOT NULL,
  `survey_type` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 27
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`survey_questions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`survey_questions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `survey_master_id` INT(11) NOT NULL,
  `survey_question` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `survey_questions_ibfk_1` (`survey_master_id` ASC) VISIBLE,
  CONSTRAINT `survey_questions_ibfk_1`
    FOREIGN KEY (`survey_master_id`)
    REFERENCES `CSCI5308_16_DEVINT`.`survey_master` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 33
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`survey_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`survey_details` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `survey_question_id` INT(11) NOT NULL,
  `survey_answer` TEXT NOT NULL,
  `user_id` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `survey_answers_ibfk_1` (`survey_question_id` ASC) VISIBLE,
  CONSTRAINT `survey_details_ibfk_1`
    FOREIGN KEY (`survey_question_id`)
    REFERENCES `CSCI5308_16_DEVINT`.`survey_questions` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 27
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `CSCI5308_16_DEVINT`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CSCI5308_16_DEVINT`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `bloodgroup` VARCHAR(45) NULL DEFAULT NULL,
  `userId` VARCHAR(90) NULL DEFAULT NULL,
  `userType` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;