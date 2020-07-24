CREATE TABLE IF NOT EXISTS `role` (
    `id`   bigint       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`  varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

insert into role(name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

CREATE TABLE IF NOT EXISTS `remuneration` (
    `id`   bigint       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `code`  varchar(255) NOT NULL,
    `description`  varchar(255) DEFAULT NULL,
    `name`  varchar(255) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

insert into remuneration(code, description, name)
VALUES ('c1234', 'desc i123', 'Fixe'),
       ('c7654', 'desc 2', 'Variable');

CREATE TABLE IF NOT EXISTS `departement` (
    `id`   bigint       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `label`  varchar(255) NOT NULL,
    `type`  varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

insert into departement(label, type)
VALUES ('dep1', 'Administratif'),
       ('dep1', 'Service');

CREATE TABLE IF NOT EXISTS `employe` (
    `id`   bigint       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username`  varchar(255) NOT NULL,
    `password`  varchar(255) NOT NULL,
     `role_id` bigint  NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

insert into employe(username, password, role_id)
VALUES ('admin', '$2a$10$ziXAaSVV0QUp9HLmORgoqONsReRxZWbGsxoxjd6DYrCBr05pQ2Tay', '2');






