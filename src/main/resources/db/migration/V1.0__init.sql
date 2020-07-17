CREATE TABLE IF NOT EXISTS `role` (
    `id`   bigint       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(255) NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

insert into role(name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');
