CREATE TABLE `blood_donated_details` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `donor_id` VARCHAR(45) NULL,
  `blood_group` VARCHAR(45) NULL,
  `donated_at` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `org_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `blood_request_organisation` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `org_id` VARCHAR(45) NULL,
  `receiver_org_id` VARCHAR(45) NULL,
  `units_required` INT NULL,
  `status` VARCHAR(45) NULL,
  `blood_group` VARCHAR(45) NULL,
  `timestamp` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

