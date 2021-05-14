CREATE DATABASE `pigletter`;

USE 'pigletter';

CREATE TABLE IF NOT EXISTS `article_tbl`(
   `article_id` INT UNSIGNED AUTO_INCREMENT,
   `title` VARCHAR(40) NOT NULL,
   `author_id` INT NOT NULL,
   `private` TINYINT NOT NULL DEFAULT 0,
   'star_num' INT NOT NULL DEFAULT 0,
   'comment_num' INT NOT NULL DEFAULT 0,
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

CREATE TABLE IF NOT EXISTS `resource_mapping_tbl`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `article_id` INT NOT NULL,
   `resource_path` VARCHAR(1000) NOT NULL,
   `deleted` TINYINT NOT NULL DEFAULT 0,
   PRIMARY KEY (`id`)
)DEFAULT CHARSET=UTF8MB4;

CREATE TABLE IF NOT EXISTS `user_tbl`(
   `user_id` INT UNSIGNED AUTO_INCREMENT,
   `user_name` VARCHAR(32) UNIQUE NOT NULL,
   `pswd` VARCHAR(64) NOT NULL,
   `salt` VARCHAR(64) NOT NULL,
   `nick_name` VARCHAR(40) NOT NULL,
   `profile_photo_path` VARCHAR(1000),
   `mail` VARCHAR(64),
   `birthday` VARCHAR(64),
   `description` VARCHAR(500),
   `gender` TINYINT NOT NULL DEFAULT 1,
   `deleted` TINYINT NOT NULL DEFAULT 0,
   `registed_time` TIMESTAMP DEFAULT NOW(),
   PRIMARY KEY (`user_id`)
)DEFAULT CHARSET=UTF8MB4;

CREATE TABLE IF NOT EXISTS `comment_tbl` (
  `comment_id` INT UNSIGNED AUTO_INCREMENT,
  `article_id` INT NOT NULL,
  `pre_comment_id` INT DEFAULT NULL,
  `comment_content` text,
  `user_id` INT DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (`comment_id`),
  UNIQUE KEY `pre_comment_id` (`pre_comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `follows_tbl` (
  `id` INT AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `follower_id` INT NOT NULL,
  `status` TINYINT DEFAULT 1,
  `comment_content` text,
  `user_id` INT DEFAULT NULL,
  `create_time` TIMESTAMP DEFAULT NOW(),
  `last_updated_time` TIMESTAMP DEFAULT NOW() ON UPDATE NOW(),
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#-------------------------------init
#pwd=m123456
INSERT INTO user_tbl(USER_NAME, PSWD, SALT,NICK_NAME)
VALUES
       ('axikuazei01','b0b738b4d778f725b44feec66a1f917e548786e87c91c7e14487bd2271d52359', '317851be-d8f9-4500-a9af-c743cf85868e','肮脏的小翅膀01'),
       ('axikuazei02','62c642261287775127388908da26a915a7b49764aa24572f58482adab2bb8408', 'e82ad7cd-b04b-4e7e-8df3-167d2f3fb184','肮脏的小翅膀02'),
       ('axikuazei03','46797befdc1a5cd3bc8ad5e1dae6caaff13d8333d6c44067f99a2a1a8bb6cdd0', '79a68cef-1009-4a07-8020-229760a34229','肮脏的小翅膀03');

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