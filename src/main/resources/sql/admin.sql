/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80021
Source Host           : localhost:3306
Source Database       : webtest

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2020-11-19 09:04:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '测试一', '123');
INSERT INTO `admin` VALUES ('3', '测试二', '123456');
INSERT INTO `admin` VALUES ('5', '信息', '12345');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `type` tinyint(1) DEFAULT NULL COMMENT '收藏类型 （0：歌曲，1：歌单）',
  `song_id` int DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int DEFAULT NULL COMMENT '歌单id',
  `create_time` datetime DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收藏';

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `type` tinyint(1) DEFAULT NULL COMMENT '收藏类型 （0：歌曲，1：歌单）',
  `song_id` int DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int DEFAULT NULL COMMENT '歌单id',
  `create_time` datetime DEFAULT NULL COMMENT '评论时间',
  `content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `up` int DEFAULT '0' COMMENT '评论点赞数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `password` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `phone_num` char(15) DEFAULT NULL COMMENT '电话号码',
  `email` char(30) DEFAULT NULL COMMENT '邮箱',
  `avator` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `birth` datetime DEFAULT NULL COMMENT '生日',
  `location` varchar(255) DEFAULT NULL COMMENT '地区',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='前端人员';

-- ----------------------------
-- Records of consumer
-- ----------------------------

-- ----------------------------
-- Table structure for list_song
-- ----------------------------
DROP TABLE IF EXISTS `list_song`;
CREATE TABLE `list_song` (
  `id` int NOT NULL AUTO_INCREMENT,
  `song_id` int DEFAULT NULL COMMENT '歌曲id',
  `song_list_id` int DEFAULT NULL COMMENT '歌单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='歌单里包含的歌曲列表';

-- ----------------------------
-- Records of list_song
-- ----------------------------

-- ----------------------------
-- Table structure for rank
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank` (
  `id` int NOT NULL AUTO_INCREMENT,
  `song_list_id` int DEFAULT NULL COMMENT '歌单id',
  `consumer_id` int DEFAULT NULL COMMENT '用户id',
  `score` int DEFAULT NULL COMMENT '评分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='评论';

-- ----------------------------
-- Records of rank
-- ----------------------------

-- ----------------------------
-- Table structure for singer
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '歌手名',
  `sex` tinyint(1) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL COMMENT '歌手照片',
  `birth` datetime DEFAULT NULL COMMENT '歌手生日',
  `location` varchar(255) DEFAULT NULL COMMENT '歌手地址',
  `introduction` varchar(255) DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='歌手';

-- ----------------------------
-- Records of singer
-- ----------------------------
INSERT INTO `singer` VALUES ('3', '123', '1', '111', '2006-06-06 00:00:00', '111', '123');
INSERT INTO `singer` VALUES ('4', 'nn', '1', 'hl', '2020-09-02 08:00:00', 'sg', '11');
INSERT INTO `singer` VALUES ('6', '1', '0', '1', '2020-11-16 14:58:08', '1', '11');
INSERT INTO `singer` VALUES ('7', '张五', '0', 'string', '2020-11-16 15:38:06', 'string', 'string');
INSERT INTO `singer` VALUES ('8', '张三', '0', 'string', '2020-11-16 15:20:43', 'string', 'string');
INSERT INTO `singer` VALUES ('9', '张四', '0', 'string', '2020-11-16 15:20:43', 'string', 'string');

-- ----------------------------
-- Table structure for song
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `singer_id` int DEFAULT NULL COMMENT '歌手id',
  `name` varchar(255) DEFAULT NULL COMMENT '歌曲名',
  `introduction` varchar(255) DEFAULT NULL COMMENT '简介',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `pic` varchar(255) DEFAULT NULL COMMENT '歌曲图片',
  `lyric` text COMMENT '歌词',
  `url` varchar(255) DEFAULT NULL COMMENT '歌曲地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='歌曲';

-- ----------------------------
-- Records of song
-- ----------------------------
INSERT INTO `song` VALUES ('1', '7', '3', '4', '2020-11-17 10:04:14', '2020-11-18 10:04:18', '1', '1', '1');
INSERT INTO `song` VALUES ('2', '2', '2', '2', '2020-11-19 10:04:36', '2020-11-20 10:04:39', '2', '2', '2');
INSERT INTO `song` VALUES ('3', '0', 'string', 'string', '2020-11-17 16:35:22', '2020-11-17 16:35:22', 'string', 'string', 'string');
INSERT INTO `song` VALUES ('4', '7', '111', '111', '2020-11-17 16:38:22', '2020-11-17 16:38:22', 'string', '1111', 'string');
INSERT INTO `song` VALUES ('5', '7', '111', '111', '2020-11-17 16:38:22', '2020-11-17 16:38:22', 'string', '1111', 'string');
INSERT INTO `song` VALUES ('6', '7', 'string', 'string', '2020-11-18 08:00:00', '2020-11-18 08:00:00', 'string', 'string', 'string');

-- ----------------------------
-- Table structure for song_list
-- ----------------------------
DROP TABLE IF EXISTS `song_list`;
CREATE TABLE `song_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '歌单名',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `introduction` varchar(255) DEFAULT NULL COMMENT '简介',
  `style` varchar(255) DEFAULT NULL COMMENT '风格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='歌单';

-- ----------------------------
-- Records of song_list
-- ----------------------------
INSERT INTO `song_list` VALUES ('7', '12', '123', '234234', '345435');

-- ----------------------------
-- Table structure for t_palce
-- ----------------------------
DROP TABLE IF EXISTS `t_palce`;
CREATE TABLE `t_palce` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `picpath` varchar(100) DEFAULT NULL,
  `hottime` timestamp NULL DEFAULT NULL,
  `hotticket` double(7,2) DEFAULT NULL,
  `dimticket` double(7,2) DEFAULT NULL,
  `placedes` varchar(300) DEFAULT NULL,
  `provinceid` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_palce
-- ----------------------------
INSERT INTO `t_palce` VALUES ('1', '南京', '1', '2020-10-20 10:38:21', '444.00', '0.00', 'cc', '1');
INSERT INTO `t_palce` VALUES ('2', '哈尔滨', '2', '2020-11-20 10:38:21', '22.00', '0.00', 'dd', '1');
INSERT INTO `t_palce` VALUES ('3', '无锡', '3', '2020-11-05 08:37:08', '111.00', '11.00', '11', '1');

-- ----------------------------
-- Table structure for t_province
-- ----------------------------
DROP TABLE IF EXISTS `t_province`;
CREATE TABLE `t_province` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `tags` varchar(80) DEFAULT NULL,
  `placecounts` int(10) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_province
-- ----------------------------
INSERT INTO `t_province` VALUES ('0000000001', '青岛', '11', '0000000022');
INSERT INTO `t_province` VALUES ('0000000002', '无锡', '小笼包', '0000000000');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(60) DEFAULT NULL,
  `userpassword` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
