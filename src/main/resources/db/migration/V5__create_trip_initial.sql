CREATE TABLE `trips` (
  `id`            INT        NOT NULL AUTO_INCREMENT,
  `version`       INT        NOT NULL DEFAULT 0,
  `start_time`    TIMESTAMP  NOT NULL DEFAULT now(),
  `end_time`      TIMESTAMP  NOT NULL DEFAULT now(),
  `cost`          INT        NOT NULL DEFAULT 0,
  `tip`           INT        NOT NULL DEFAULT 0,
  `total_cost`    INT        NOT NULL DEFAULT 0,
  `kms_driven`    INT        NOT NULL DEFAULT 0,
  `car_id`        INT        NOT NULL,
  `driver_id`     INT        NOT NULL,
  `passenger_id`  INT        NOT NULL,
  `city_id`       INT        NOT NULL,
  `created`       TIMESTAMP  NOT NULL DEFAULT now(),
  `modified`      TIMESTAMP  NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_car_id`
  FOREIGN KEY (`car_id`)
  REFERENCES `cars` (`id`),

  CONSTRAINT `fk_driver_id`
  FOREIGN KEY (`driver_id`)
  REFERENCES `drivers` (`id`),

  CONSTRAINT `fk_city_id`
  FOREIGN KEY (`city_id`)
  REFERENCES `cities` (`id`),

  CONSTRAINT `fk_passenger_id`
  FOREIGN KEY (`passenger_id`)
  REFERENCES `passengers` (`id`));
