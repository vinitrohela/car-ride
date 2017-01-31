CREATE TABLE `drivers` (
  `id`          INT                     NOT NULL AUTO_INCREMENT,
  `version`     INT                     NOT NULL DEFAULT 0,
  `name`        VARCHAR(225)            NOT NULL,
  `age`         INT                     NOT NULL,
  `gender`      ENUM('MALE', 'FEMALE')  NOT NULL,
  `violations`  INT                     NOT NULL DEFAULT 0,
  `created`     TIMESTAMP               NOT NULL DEFAULT now(),
  `modified`    TIMESTAMP               NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`));
