/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : awadmin

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 29/01/2021 13:35:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for global_depart
-- ----------------------------
DROP TABLE IF EXISTS `global_depart`;
CREATE TABLE `global_depart`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门ID,UUID,NOT NULL,PRIMARY KEY',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `createDate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建日期',
  `createUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人标识,UUID',
  `createName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `managerUID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人,UUID',
  `managerName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人姓名,UUID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `parentId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '父级部门ID,UUID',
  `shortName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门简称',
  `sort` decimal(10, 0) NULL DEFAULT NULL COMMENT '排序',
  `state` decimal(10, 0) NULL DEFAULT NULL COMMENT '状态,1:有效/0:注销',
  `telephone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `zipCode` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `orgName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织域名',
  `orgType` decimal(10, 0) NULL DEFAULT NULL COMMENT '组织类型',
  `orgCode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织机构代码',
  `orgLevel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织层级编码',
  `administrationCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行政区划编码+部门编码 ：唯一类型',
  `administrationLevel` decimal(10, 0) NULL DEFAULT NULL COMMENT '行政等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of global_depart
-- ----------------------------
INSERT INTO `global_depart` VALUES ('a6fc7b69f30546beb7cd49d8afc55dd2', '中国', '2019-03-24 01:11:55', NULL, NULL, NULL, NULL, '中国', NULL, '', '中国', 1, 1, '1', NULL, NULL, 1, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for global_function
-- ----------------------------
DROP TABLE IF EXISTS `global_function`;
CREATE TABLE `global_function`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '功能ID,NOT NULL,PRIMARY KEY',
  `createDate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建日期',
  `createUId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人ID,UUID',
  `createName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接地址',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能图标',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能名称',
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `parentId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父亲节点,UUID',
  `sort` decimal(10, 0) NULL DEFAULT NULL COMMENT '排序',
  `state` decimal(10, 0) NULL DEFAULT NULL COMMENT '是否启用,0:禁用  1:开放',
  `type` decimal(10, 0) NULL DEFAULT NULL COMMENT '功能类型, 1:模块2:链接 3:权限',
  `visibility` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '可见性,0:不可见 1：可见',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of global_function
-- ----------------------------
INSERT INTO `global_function` VALUES ('0f89cd376d4845a09f7105fa6afc9a7c', '2019-04-10 14:24:20', NULL, NULL, '/user/userLogin', NULL, '事件1', NULL, 'df3f90a106dc45f785c51f2f602f1d42', 3, 1, 3, '1');
INSERT INTO `global_function` VALUES ('2a6d2ab07690426f8e8acd11c12ec7b4', '2019-04-12 10:25:19', NULL, NULL, '/common/index', NULL, '浏览首页', NULL, '366d2c4d38e64dcc8497d4236b0effaf', 2, 1, 2, '1');
INSERT INTO `global_function` VALUES ('2babc4ee128a455cbb4f067771667ee2', '2019-04-09 18:40:34', NULL, '', '/common/init', '', '权限1', NULL, 'df3f90a106dc45f785c51f2f602f1d42', 1, 1, 0, '1');

-- ----------------------------
-- Table structure for global_log
-- ----------------------------
DROP TABLE IF EXISTS `global_log`;
CREATE TABLE `global_log`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志ID,UUID,NOT NULL,PRIMARY KEY',
  `description` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述,不操作2000个字符',
  `functionId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能模块ID,UUID',
  `ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作IP地址',
  `loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `operationDate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '操作时间',
  `operationType` decimal(10, 0) NULL DEFAULT NULL COMMENT '操作类型,0:增 1：删除2：改 3：读',
  `functionName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功功能模块名称',
  `createId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户标识,UUID',
  `createName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `logType` decimal(10, 0) NULL DEFAULT NULL COMMENT '日志类型 1:系统切面日志 2 ：操作记录日志 3:功能点击日志',
  `operationCate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志操作分类',
  `describe` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '完整操作描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for global_role
-- ----------------------------
DROP TABLE IF EXISTS `global_role`;
CREATE TABLE `global_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID,UUID,NOT NULL,PRIMARY KEY',
  `createDate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建日期',
  `createId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人标识,UUID',
  `createrName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `sort` decimal(10, 0) NULL DEFAULT NULL COMMENT '排序',
  `state` decimal(10, 0) NULL DEFAULT NULL COMMENT '状态,0：开放 1：禁止',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of global_role
-- ----------------------------
INSERT INTO `global_role` VALUES ('9ef64a3545fe4afe96d6fd37020a10ed', '2019-04-10 17:53:45', NULL, NULL, '超级管理员', NULL, 1, 0);

-- ----------------------------
-- Table structure for global_role_function
-- ----------------------------
DROP TABLE IF EXISTS `global_role_function`;
CREATE TABLE `global_role_function`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `roleId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `functionId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块id(权限id)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of global_role_function
-- ----------------------------
INSERT INTO `global_role_function` VALUES ('2f6a34f28afb8f159d2c6df0c27f06e8', '9ef64a3545fe4afe96d6fd37020a10ed', '2babc4ee128a455cbb4f067771667ee2');
INSERT INTO `global_role_function` VALUES ('3c5310fafc6757a9e2c39bd38b3aafe4', '9ef64a3545fe4afe96d6fd37020a10ed', '0f89cd376d4845a09f7105fa6afc9a7c');
INSERT INTO `global_role_function` VALUES ('ee1c81816e34ed3bfd7f01186afcdf87', '9ef64a3545fe4afe96d6fd37020a10ed', '2a6d2ab07690426f8e8acd11c12ec7b4');

-- ----------------------------
-- Table structure for global_roleuser
-- ----------------------------
DROP TABLE IF EXISTS `global_roleuser`;
CREATE TABLE `global_roleuser`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID,UUID,NOT NULL,PRIMARY KEY',
  `roleId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID,UUID,NOT NULL,PRIMARY KEY',
  `userId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '成员ID,UUID,NOT NULL,PRIMARY KEY',
  PRIMARY KEY (`id`, `roleId`, `userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of global_roleuser
-- ----------------------------
INSERT INTO `global_roleuser` VALUES ('c6737355b560430caf7168ec7df2a92b', '9ef64a3545fe4afe96d6fd37020a10ed', '1c122e9f37f24c93b5451c0220f1b548');

-- ----------------------------
-- Table structure for global_setup
-- ----------------------------
DROP TABLE IF EXISTS `global_setup`;
CREATE TABLE `global_setup`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID,UUID,NOT NULL,PRIMARY KEY',
  `logo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'LOGO路径',
  `organization` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属组织机构',
  `systemName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统名称',
  `version` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本',
  `createDate` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建日期',
  `createId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人标识,UUID',
  `createName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `copyRight` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版权信息',
  `support` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '技术支持',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for global_user
-- ----------------------------
DROP TABLE IF EXISTS `global_user`;
CREATE TABLE `global_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID,UUID,NOT NULL,PRIMARY KEY',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭住址',
  `birthday` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '出生年月',
  `idCard` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `fax` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真',
  `ip` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册IP地址',
  `post` decimal(10, 0) NULL DEFAULT NULL COMMENT '职务或岗位',
  `loginCount` decimal(10, 0) NULL DEFAULT NULL COMMENT '登录次数',
  `loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名称',
  `loginTime` timestamp(0) NOT NULL COMMENT '最后登录时间',
  `mobile` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `nick` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `remarks` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注说明',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `picture` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人头像路径',
  `zipCode` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `regdate` timestamp(0) NOT NULL COMMENT '注册日期',
  `sex` decimal(10, 0) NULL DEFAULT NULL COMMENT '性别,0：未知性别1：男性 2：女性',
  `shortString` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短号',
  `sort` decimal(10, 0) NULL DEFAULT NULL COMMENT '排序',
  `state` decimal(10, 0) NULL DEFAULT NULL COMMENT '用户状态,1：有效、0：注销',
  `telephone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `departId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门ID,UUID,FOREIGN KEY',
  `createDate` timestamp(0) NOT NULL COMMENT '创建日期',
  `createId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人标识,UUID',
  `createName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `isAdmin` decimal(10, 0) NULL DEFAULT NULL COMMENT '是否是超级管理员，1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of global_user
-- ----------------------------
INSERT INTO `global_user` VALUES ('1c122e9f37f24c93b5451c0220f1b548', NULL, '2021-01-29 10:59:10', NULL, NULL, NULL, NULL, NULL, NULL, 'admin', '0000-00-00 00:00:00', '15336692852', '超级管理员', 'admin', NULL, '202cb962ac59075b964b07152d234b70', NULL, NULL, '0000-00-00 00:00:00', 0, NULL, 2, 1, NULL, 'a6fc7b69f30546beb7cd49d8afc55dd2', '2019-04-10 16:55:37', NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
