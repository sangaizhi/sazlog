/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-09-26 23:28:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主鍵',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `password` varchar(64) NOT NULL COMMENT '密碼',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT 'email',
  `avatar` varchar(254) DEFAULT NULL COMMENT '头像',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理人员表';

-- ----------------------------
-- Records of t_admin
-- ----------------------------

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '发表人',
  `user_name` varchar(50) NOT NULL COMMENT '发表人昵称（冗余数据，方便）',
  `title` varchar(254) NOT NULL COMMENT '标题',
  `category_id` bigint(20) DEFAULT NULL COMMENT '文章分类id',
  `category_name` varchar(50) DEFAULT NULL COMMENT '文章分类名称（冗余数据，方便查询）',
  `star` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `summary` text,
  `label` varchar(254) DEFAULT NULL COMMENT '文章标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of t_article
-- ----------------------------

-- ----------------------------
-- Table structure for t_article_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_article_detail`;
CREATE TABLE `t_article_detail` (
  `id` bigint(20) NOT NULL COMMENT '主键，同步文章id',
  `content` text NOT NULL COMMENT '文章内容',
  `original_content` text NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章详细信息表';

-- ----------------------------
-- Records of t_article_detail
-- ----------------------------

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主鍵',
  `user_id` bigint(20) NOT NULL COMMENT '所属用户',
  `name` varchar(50) NOT NULL COMMENT '分类名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级分类id',
  `remark` varchar(254) DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 COMMENT='文章分类表';

-- ----------------------------
-- Records of t_category
-- ----------------------------

-- ----------------------------
-- Table structure for t_collect
-- ----------------------------
DROP TABLE IF EXISTS `t_collect`;
CREATE TABLE `t_collect` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主鍵',
  `user_id` bigint(20) NOT NULL COMMENT '收藏人',
  `title` varchar(254) NOT NULL COMMENT '收藏标题',
  `link` varchar(254) NOT NULL COMMENT '链接地址',
  `remark` varchar(254) DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收藏表';

-- ----------------------------
-- Records of t_collect
-- ----------------------------

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主鍵',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名称',
  `topic` smallint(2) NOT NULL COMMENT '评论的主题类型',
  `topic_id` bigint(20) NOT NULL COMMENT '评论的主题id',
  `content` text NOT NULL COMMENT '评论内容',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for t_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_reply`;
CREATE TABLE `t_reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `comment_id` bigint(20) NOT NULL COMMENT '评论id',
  `content` text NOT NULL COMMENT '回复内容',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='回复表';

-- ----------------------------
-- Records of t_reply
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `status` smallint(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `password` varchar(64) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `profile` varchar(254) DEFAULT NULL COMMENT '用户头像地址',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_attention
-- ----------------------------
DROP TABLE IF EXISTS `t_user_attention`;
CREATE TABLE `t_user_attention` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '关注者id',
  `attention_user_id` bigint(20) NOT NULL COMMENT '被关注者id',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与用户之间关注表';

-- ----------------------------
-- Records of t_user_attention
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_extra
-- ----------------------------
DROP TABLE IF EXISTS `t_user_extra`;
CREATE TABLE `t_user_extra` (
  `id` bigint(20) NOT NULL COMMENT '主键,同步用户主表',
  `sex` smallint(2) DEFAULT NULL COMMENT '性别',
  `birth` datetime DEFAULT NULL COMMENT '出生日期',
  `address` varchar(254) DEFAULT NULL COMMENT '居住地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息附加表';

-- ----------------------------
-- Records of t_user_extra
-- ----------------------------

-- ----------------------------
-- Table structure for t_visitor
-- ----------------------------
DROP TABLE IF EXISTS `t_visitor`;
CREATE TABLE `t_visitor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主鍵',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `visitor_id` bigint(20) NOT NULL COMMENT '访客id',
  `visitor_name` varchar(50) NOT NULL COMMENT '访客昵称',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访客表';

-- ----------------------------
-- Records of t_visitor
-- ----------------------------
