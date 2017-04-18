/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2013-02-20 14:26:49
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `PK_ID` bigint(20) NOT NULL,
  `FK_USER_ID` bigint(20) default NULL,
  `RECEIVE_NAME` varchar(100) default NULL,
  `RECEIVE_ADDRESS` varchar(1000) default NULL,
  `POSTAL_CODE` varchar(100) default NULL,
  `MOBIE` varchar(200) default NULL,
  `PHONE` varchar(200) default NULL,
  `EMAIL` varchar(200) default NULL,
  `PAYMENT` int(11) default NULL COMMENT '1,货到付款；2.在线支付；',
  `STATUS` int(11) default NULL,
  `IS_DONE` int(11) default NULL COMMENT '1.未处理；2.处理通过；3.处理不通过',
  `IS_VALID` int(11) default '1',
  `CREATE_DATE` datetime default NULL,
  `UPDATE_DATE` datetime default NULL,
  `B1` varchar(1000) default NULL,
  `B2` varchar(1000) default NULL,
  `B3` varchar(1000) default NULL,
  PRIMARY KEY  (`PK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收获地址表; InnoDB free: 8192 kB';

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `phone` varchar(30) default NULL,
  `sex` varchar(2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------

-- ----------------------------
-- Table structure for `e_receive_address`
-- ----------------------------
DROP TABLE IF EXISTS `e_receive_address`;
CREATE TABLE `e_receive_address` (
  `PK_ID` bigint(20) NOT NULL,
  `FK_USER_ID` bigint(20) default NULL,
  `RECEIVE_NAME` varchar(100) default NULL,
  `RECEIVE_ADDRESS` varchar(1000) default NULL,
  `POSTAL_CODE` varchar(100) default NULL,
  `MOBIE` varchar(200) default NULL,
  `PHONE` varchar(200) default NULL,
  `EMAIL` varchar(200) default NULL,
  `PAYMENT` int(11) default NULL COMMENT '1,货到付款；2.在线支付；',
  `STATUS` int(11) default NULL,
  `IS_DONE` int(11) default NULL COMMENT '1.未处理；2.处理通过；3.处理不通过',
  `IS_VALID` int(11) default '1',
  `CREATE_DATE` datetime default NULL,
  `UPDATE_DATE` datetime default NULL,
  PRIMARY KEY  (`PK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收获地址表; InnoDB free: 8192 kB';

-- ----------------------------
-- Records of e_receive_address
-- ----------------------------

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(11) NOT NULL auto_increment,
  `price` double(10,2) NOT NULL,
  `goodName` varchar(20) NOT NULL,
  PRIMARY KEY  (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('3', '5200.00', 'thinkpads笔记本');
INSERT INTO `goods` VALUES ('4', '5200.00', 'thinkpads笔记本');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10', 'ddddd', 'ddddd');
INSERT INTO `user` VALUES ('11', '11145', '111111');
INSERT INTO `user` VALUES ('12', 'tttt', 'tttt');
INSERT INTO `user` VALUES ('13', 'gggg', 'gggg');
INSERT INTO `user` VALUES ('14', 'yyyy', 'yyyy');
INSERT INTO `user` VALUES ('15', 'ssss', 'ssss');
INSERT INTO `user` VALUES ('16', 'eeee', 'eeee');
INSERT INTO `user` VALUES ('17', 'rrrr', 'rrrr');
INSERT INTO `user` VALUES ('18', 'oooo', 'oooo');
INSERT INTO `user` VALUES ('19', 'pppp', 'pppp');
INSERT INTO `user` VALUES ('20', '2222', '2222');
INSERT INTO `user` VALUES ('21', 'rrrrr', 'rrrrr');
INSERT INTO `user` VALUES ('22', 'admin', 'admin');
INSERT INTO `user` VALUES ('23', 'aaaaa', 'aaaaa');
INSERT INTO `user` VALUES ('24', 'add', 'add');
INSERT INTO `user` VALUES ('26', 'ddd', 'ddd');
INSERT INTO `user` VALUES ('27', 'vs', 'v');
INSERT INTO `user` VALUES ('28', 'dssdd', 'dddd');
INSERT INTO `user` VALUES ('29', 'aa', 'aa');
INSERT INTO `user` VALUES ('30', 'a', 'a');
