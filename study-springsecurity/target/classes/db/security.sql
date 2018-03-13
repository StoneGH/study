/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-02-15 10:46:55
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `func`
-- ----------------------------
DROP TABLE IF EXISTS `func`;
CREATE TABLE `func` (
  `id` varchar(50) NOT NULL COMMENT '功能编号',
  `name` varchar(30) NOT NULL COMMENT '功能名称',
  `url` varchar(255) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `flag` varchar(2) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of func
-- ----------------------------
INSERT INTO func VALUES ('1', '管理页', '/admin', null, '1');
INSERT INTO func VALUES ('2', '报表页', '/data', null, '1');
INSERT INTO func VALUES ('3', '欢迎页', '/index', null, '1');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(50) NOT NULL COMMENT '编号',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `flag` varchar(2) NOT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO role VALUES ('1', '管理员', '系统管理员', '1');
INSERT INTO role VALUES ('2', '统计员', '数据统计员', '1');

-- ----------------------------
-- Table structure for `role_func_relation`
-- ----------------------------
DROP TABLE IF EXISTS `role_func_relation`;
CREATE TABLE `role_func_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(50) NOT NULL COMMENT '角色编号',
  `func_id` varchar(50) NOT NULL COMMENT '功能编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_func_relation
-- ----------------------------
INSERT INTO role_func_relation VALUES ('1', '1', '1');
INSERT INTO role_func_relation VALUES ('2', '2', '2');
INSERT INTO role_func_relation VALUES ('3', '1', '3');
INSERT INTO role_func_relation VALUES ('4', '2', '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT '编号',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `flag` int(2) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('1', 'admin', 'admin', '1');
INSERT INTO user VALUES ('2', 'user01', 'user01', '1');

-- ----------------------------
-- Table structure for `user_role_relation`
-- ----------------------------
DROP TABLE IF EXISTS `user_role_relation`;
CREATE TABLE `user_role_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) NOT NULL COMMENT '用户编号',
  `role_id` varchar(50) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_relation
-- ----------------------------
INSERT INTO user_role_relation VALUES ('1', '1', '1');
INSERT INTO user_role_relation VALUES ('2', '2', '2');
