CREATE DATABASE `pigletter`;

CREATE TABLE IF NOT EXISTS `article_tbl`(
   `article_id` INT UNSIGNED AUTO_INCREMENT,
   `title` VARCHAR(40) NOT NULL,
   `author_id` INT NOT NULL,
   `published_time` TIMESTAMP DEFAULT NOW(),
   `last_updated_time` TIMESTAMP DEFAULT NOW() ON UPDATE NOW(),
   `deleted` TINYINT NOT NULL default 0,
   PRIMARY KEY (`article_id`)
)DEFAULT CHARSET=UTF8MB4;

CREATE TABLE IF NOT EXISTS `article_content_tbl`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `article_id` INT NOT NULL,
   `content` TEXT NOT NULL,
   `deleted` TINYINT NOT NULL DEFAULT 0,
   PRIMARY KEY (`id`)
)DEFAULT CHARSET=UTF8MB4;

CREATE TABLE IF NOT EXISTS `user_tbl`(
   `user_id` INT UNSIGNED AUTO_INCREMENT,
   `user_name` VARCHAR(32) UNIQUE NOT NULL,
   `pswd` VARCHAR(32) NOT NULL,
   `nick_name` VARCHAR(40) NOT NULL,
   `gender` TINYINT NOT NULL DEFAULT 1,
   `deleted` TINYINT NOT NULL DEFAULT 0,
   `registed_time` TIMESTAMP DEFAULT NOW(),
   PRIMARY KEY (`user_id`)
)DEFAULT CHARSET=UTF8MB4;

#-------------------------------init
INSERT INTO user_tbl(USER_NAME, PSWD, NICK_NAME)
VALUES
       ('axikuazei01','123456','肮脏的小翅膀01'),
       ('axikuazei02','123456','肮脏的小翅膀02'),
       ('axikuazei03','123456','肮脏的小翅膀03');

INSERT INTO article_tbl(title, author_id)
VALUES
        ('日记01',1),
        ('日记02',1),
        ('日记03',2),
        ('日记04',2),
        ('日记05',3),
        ('日记06',4);

INSERT INTO article_content_tbl(article_id, content)
VALUES
    (1,'日记01的内容'),
    (2,'日记02的内容'),
    (3,'日记03的内容'),
    (4,'日记04的内容'),
    (5,'日记05的内容'),
    (6,'日记06的内容');