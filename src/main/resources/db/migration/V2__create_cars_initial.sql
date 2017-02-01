CREATE TABLE `cars` (
  `id`        INT                   NOT NULL AUTO_INCREMENT,
  `version`   INT                   NOT NULL DEFAULT 0,
  `make`      VARCHAR(100)          NOT NULL,
  `model`     VARCHAR(100)          NOT NULL,
  `year`      INT                   NOT NULL,
  `car_type`  ENUM('BASIC', 'LUX')  NOT NULL,
  `created`   TIMESTAMP             NOT NULL DEFAULT now(),
  `modified`  TIMESTAMP             NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`));