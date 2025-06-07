/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50639
 Source Host           : localhost:3306
 Source Schema         : cross-gateway

 Target Server Type    : MySQL
 Target Server Version : 50639
 File Encoding         : 65001

 Date: 11/03/2023 15:04:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for application_interface
-- ----------------------------
DROP TABLE IF EXISTS `application_interface`;
CREATE TABLE `application_interface` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `system_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '系统标识',
  `interface_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '接口标识',
  `interface_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '接口名称',
  `interface_version` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '接口版本',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx` (`system_id`,`interface_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of application_interface
-- ----------------------------
BEGIN;
INSERT INTO `application_interface` VALUES (16, 'cross-gateway-test-provider', 'cn.rockystudio.gateway.rpc.IActivityBooth', '活动服务', '1.0.0', '2023-01-01 10:02:15', '2023-01-01 10:02:15');
COMMIT;

-- ----------------------------
-- Table structure for application_interface_method
-- ----------------------------
DROP TABLE IF EXISTS `application_interface_method`;
CREATE TABLE `application_interface_method` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `system_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '系统标识',
  `interface_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '接口标识',
  `method_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '方法标识',
  `method_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '方法名称',
  `parameter_type` varchar(256) COLLATE utf8_bin DEFAULT NULL COMMENT '参数类型；(RPC 限定单参数注册)；new String[]{"java.lang.String"}、new String[]{"cn.rockystudio.gateway.rpc.dto.XReq"}',
  `uri` varchar(126) COLLATE utf8_bin DEFAULT NULL COMMENT '网关接口',
  `http_command_type` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '接口类型；GET、POST、PUT、DELETE',
  `auth` int(4) DEFAULT NULL COMMENT 'true = 1是、false = 0否',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx` (`system_id`,`interface_id`,`method_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of application_interface_method
-- ----------------------------
BEGIN;
INSERT INTO `application_interface_method` VALUES (43, 'cross-gateway-test-provider', 'cn.rockystudio.gateway.rpc.IActivityBooth', 'sayHi', '探活方法', 'java.lang.String', '/wg/activity/sayHi', 'GET', 0, '2023-01-01 10:02:15', '2023-01-01 10:02:15');
INSERT INTO `application_interface_method` VALUES (44, 'cross-gateway-test-provider', 'cn.rockystudio.gateway.rpc.IActivityBooth', 'insert', '插入方法', 'cn.rockystudio.gateway.rpc.dto.XReq', '/wg/activity/insert', 'POST', 1, '2023-01-01 10:02:15', '2023-01-01 10:02:15');
INSERT INTO `application_interface_method` VALUES (45, 'cross-gateway-test-provider', 'cn.rockystudio.gateway.rpc.IActivityBooth', 'test', '测试方法', 'java.lang.String,cn.rockystudio.gateway.rpc.dto.XReq', '/wg/activity/test', 'POST', 0, '2023-01-01 10:02:15', '2023-01-01 10:02:15');
COMMIT;

-- ----------------------------
-- Table structure for application_system
-- ----------------------------
DROP TABLE IF EXISTS `application_system`;
CREATE TABLE `application_system` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `system_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '系统标识',
  `system_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '系统名称',
  `system_type` varchar(4) COLLATE utf8_bin DEFAULT NULL COMMENT '系统类型；RPC、HTTP',
  `system_registry` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '注册中心',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_systemId` (`system_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of application_system
-- ----------------------------
BEGIN;
INSERT INTO `application_system` VALUES (21, 'cross-gateway-test-provider', '网关sdk测试工程', 'RPC', 'zookeeper://192.168.1.102:2181', '2023-01-01 10:02:15', '2023-01-01 10:02:15');
INSERT INTO `application_system` VALUES (22, 'cross-gateway-sdk-00', '网关sdk测试工程', 'RPC', 'zookeeper://192.168.1.105:2181', '2023-03-11 11:20:08', '2023-03-11 11:20:08');
COMMIT;

-- ----------------------------
-- Table structure for gateway_distribution
-- ----------------------------
DROP TABLE IF EXISTS `gateway_distribution`;
CREATE TABLE `gateway_distribution` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `group_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '分组标识',
  `gateway_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '网关标识',
  `system_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '系统标识',
  `system_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '系统名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uuid` (`group_id`,`gateway_id`,`system_id`) USING BTREE COMMENT '唯一索引'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of gateway_distribution
-- ----------------------------
BEGIN;
INSERT INTO `gateway_distribution` VALUES (1, '10001', 'cross-gateway-g4', 'cross-gateway-test-provider', '测试工程', '2025-11-26 13:13:00', '2025-11-26 13:13:00');
COMMIT;

-- ----------------------------
-- Table structure for gateway_server
-- ----------------------------
DROP TABLE IF EXISTS `gateway_server`;
CREATE TABLE `gateway_server` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `group_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '分组标识',
  `group_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '分组名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of gateway_server
-- ----------------------------
BEGIN;
INSERT INTO `gateway_server` VALUES (1, '10001', '廊坊网关');
INSERT INTO `gateway_server` VALUES (2, '10002', '亦庄网关');
INSERT INTO `gateway_server` VALUES (3, '10003', '东丽网关');
COMMIT;

-- ----------------------------
-- Table structure for gateway_server_detail
-- ----------------------------
DROP TABLE IF EXISTS `gateway_server_detail`;
CREATE TABLE `gateway_server_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `group_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '分组标识',
  `gateway_id` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '网关标识',
  `gateway_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '网关名称',
  `gateway_address` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '网关地址：127.0.0.1',
  `status` varchar(4) COLLATE utf8_bin DEFAULT NULL COMMENT '服务状态：0不可用、1可使用',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_gateway` (`gateway_id`,`gateway_address`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of gateway_server_detail
-- ----------------------------
BEGIN;
INSERT INTO `gateway_server_detail` VALUES (24, '10001', 'cross-gateway-g4', '电商配送网关', '192.168.1.102:7398', '1', '2023-03-11 14:12:36', '2023-03-11 14:12:36');
INSERT INTO `gateway_server_detail` VALUES (25, '10001', 'cross-gateway-g4', '电商配送网关', '192.168.1.102:7397', '1', '2023-03-11 14:33:05', '2023-03-11 14:33:05');
COMMIT;

-- ----------------------------
-- Table structure for http_statement
-- ----------------------------
DROP TABLE IF EXISTS `http_statement`;
CREATE TABLE `http_statement` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `application` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '应用名称',
  `interface_name` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '服务接口；RPC、其他',
  `method_name` varchar(128) COLLATE utf8_bin NOT NULL COMMENT ' 服务方法；RPC#method',
  `parameter_type` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '参数类型(RPC 限定单参数注册)；new String[]{"java.lang.String"}、new String[]{"cn.rockystudio.gateway.rpc.dto.XReq"}',
  `uri` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '网关接口',
  `http_command_type` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '接口类型；GET、POST、PUT、DELETE',
  `auth` int(4) NOT NULL DEFAULT '0' COMMENT 'true = 1是、false = 0否',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of http_statement
-- ----------------------------
BEGIN;
INSERT INTO `http_statement` VALUES (1, 'cross-gateway-test', 'cn.rockystudio.gateway.rpc.IActivityBooth', 'sayHi', 'java.lang.String', '/wg/activity/sayHi', 'GET', 0, '2025-10-22 15:30:00', '2025-10-22 15:30:00');
INSERT INTO `http_statement` VALUES (2, 'cross-gateway-test', 'cn.rockystudio.gateway.rpc.IActivityBooth', 'insert', 'cn.rockystudio.gateway.rpc.dto.XReq', '/wg/activity/insert', 'POST', 1, '2025-10-22 15:30:00', '2025-10-22 15:30:00');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
