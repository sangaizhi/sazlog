
set foreign_key_checks=0;

-- ----------------------------
-- table structure for t_admin
-- ----------------------------
drop table if exists `t_admin`;
create table `t_admin` (
  `id` bigint(20) not null auto_increment comment '主鍵',
  `name` varchar(50) not null comment '名称',
  `password` varchar(64) not null comment '密碼',
  `phone` varchar(11) default null comment '电话',
  `email` varchar(50) default null comment 'email',
  `avatar` varchar(254) default null comment '头像',
  `create_time` timestamp null default current_timestamp comment '创建时间',
  `modify_time` timestamp null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb auto_increment=2 default charset=utf8 comment='管理人员表';

-- ----------------------------
-- table structure for t_article
-- ----------------------------
drop table if exists `t_article`;
create table `t_article` (
  `id` bigint(20) not null auto_increment comment '主键',
  `user_id` bigint(20) not null comment '发表人',
  `user_name` varchar(50) not null comment '发表人昵称（冗余数据，方便）',
  `title` varchar(254) not null comment '标题',
  `category_id` bigint(20) default null comment '文章分类id',
  `category_name` varchar(50) default null comment '文章分类名称（冗余数据，方便查询）',
  `star` int(11) not null default '0' comment '点赞数',
  `create_time` timestamp null default current_timestamp comment '创建时间',
  `modify_time` timestamp null default current_timestamp on update current_timestamp comment '修改时间',
  `summary` text,
  `label` varchar(254) default null comment '文章标签',
  primary key (`id`)
) engine=innodb auto_increment=34 default charset=utf8 comment='文章表';

-- ----------------------------
-- table structure for t_article_detail
-- ----------------------------
drop table if exists `t_article_detail`;
create table `t_article_detail` (
  `id` bigint(20) not null comment '主键，同步文章id',
  `content` text not null comment '文章内容',
  `original_content` text not null,
  `create_time` timestamp null default current_timestamp comment '创建时间',
  `modify_time` timestamp null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8 comment='文章详细信息表';

-- ----------------------------
-- table structure for t_category
-- ----------------------------
drop table if exists `t_category`;
create table `t_category` (
  `id` bigint(20) not null auto_increment comment '主鍵',
  `user_id` bigint(20) not null comment '所属用户',
  `name` varchar(50) not null comment '分类名称',
  `parent_id` bigint(20) default null comment '父级分类id',
  `remark` varchar(254) default null comment '备注',
  `create_time` timestamp null default current_timestamp comment '创建时间',
  `modify_time` timestamp null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb auto_increment=96 default charset=utf8 comment='文章分类表';

-- ----------------------------
-- table structure for t_collect
-- ----------------------------
drop table if exists `t_collect`;
create table `t_collect` (
  `id` bigint(20) not null auto_increment comment '主鍵',
  `user_id` bigint(20) not null comment '收藏人',
  `title` varchar(254) not null comment '收藏标题',
  `link` varchar(254) not null comment '链接地址',
  `remark` varchar(254) default null comment '描述',
  `create_time` timestamp null default current_timestamp comment '创建时间',
  `modify_time` timestamp null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8 comment='收藏表';

-- ----------------------------
-- table structure for t_comment
-- ----------------------------
drop table if exists `t_comment`;
create table `t_comment` (
  `id` bigint(20) not null auto_increment comment '主鍵',
  `user_id` bigint(20) not null comment '用户id',
  `user_name` varchar(50) not null comment '用户名称',
  `topic` smallint(2) not null comment '评论的主题类型',
  `topic_id` bigint(20) not null comment '评论的主题id',
  `content` text not null comment '评论内容',
  `create_time` timestamp null default current_timestamp comment '创建时间',
  `modify_time` timestamp null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8 comment='评论表';

-- ----------------------------
-- table structure for t_reply
-- ----------------------------
drop table if exists `t_reply`;
create table `t_reply` (
  `id` bigint(20) not null auto_increment comment '主键',
  `comment_id` bigint(20) not null comment '评论id',
  `content` text not null comment '回复内容',
  `create_time` timestamp null default current_timestamp comment '创建时间',
  `modify_time` timestamp null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8 comment='回复表';

-- ----------------------------
-- table structure for t_user
-- ----------------------------
drop table if exists `t_user`;
create table `t_user` (
  `id` bigint(20) not null auto_increment comment '主键',
  `phone` varchar(20) default null comment '手机号',
  `email` varchar(50) default null comment '邮箱',
  `status` smallint(2) not null default '0' comment '状态',
  `password` varchar(64) default null,
  `nickname` varchar(50) default null comment '昵称',
  `profile` varchar(254) default null comment '用户头像地址',
  `create_time` timestamp null default current_timestamp comment '创建时间',
  `modify_time` timestamp null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb auto_increment=33 default charset=utf8 comment='用户信息表';

-- ----------------------------
-- table structure for t_user_attention
-- ----------------------------
drop table if exists `t_user_attention`;
create table `t_user_attention` (
  `id` bigint(20) not null auto_increment comment '主键',
  `userid` bigint(20) not null comment '关注者id',
  `attention_user_id` bigint(20) not null comment '被关注者id',
  `create_time` timestamp null default current_timestamp comment '创建时间',
  `modify_time` timestamp null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8 comment='用户与用户之间关注表';

-- ----------------------------
-- table structure for t_user_extra
-- ----------------------------
drop table if exists `t_user_extra`;
create table `t_user_extra` (
  `id` bigint(20) not null comment '主键,同步用户主表',
  `sex` smallint(2) default null comment '性别',
  `birth` datetime default null comment '出生日期',
  `address` varchar(254) default null comment '居住地址',
  primary key (`id`)
) engine=innodb default charset=utf8 comment='用户信息附加表';

-- ----------------------------
-- table structure for t_visitor
-- ----------------------------
drop table if exists `t_visitor`;
create table `t_visitor` (
  `id` bigint(20) not null auto_increment comment '主鍵',
  `user_id` bigint(20) not null comment '用户id',
  `visitor_id` bigint(20) not null comment '访客id',
  `visitor_name` varchar(50) not null comment '访客昵称',
  `create_time` timestamp null default current_timestamp comment '创建时间',
  `modify_time` timestamp null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
) engine=innodb default charset=utf8 comment='访客表';


drop TABLE  if EXISTS  t_kit_box
## 工具箱(工具分尅)
create table t_kit_box(
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
  name VARCHAR (50) NOT null comment '工具箱名称',
  `create_time` timestamp null default current_timestamp comment '创建时间',
  `modify_time` timestamp null default current_timestamp on update current_timestamp comment '修改时间'
)engine=innodb default charset=utf8 comment='工具箱表';

## 工具
create table t_kit(
    id bigint(20) PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    name VARCHAR (254) NOT NULL comment '名称',
    link VARCHAR (254) NOT NULL comment '链接',
    description VARCHAR (50) NOT NULL  comment '描述',
    kit_box_id BIGINT(20) NOT NULL comment '所属工具箱',
    create_time timestamp null default current_timestamp comment '创建时间',
    modify_time timestamp null default current_timestamp on update current_timestamp comment '修改时间'
) engine=innodb default charset=utf8 comment='工具表';

## 站点分类
create table t_site_cat(
  id bigint(20) PRIMARY KEY AUTO_INCREMENT comment '主键',
  name VARCHAR(50) NOT  NULL comment '名称',
  create_time timestamp null default current_timestamp comment '创建时间',
  modify_time timestamp null default current_timestamp on update current_timestamp comment '修改时间'
)engine=innodb default charset=utf8 comment='站点分类';

## 站点
create table t_site(
  id bigint(20) PRIMARY KEY AUTO_INCREMENT comment '主键',
  name VARCHAR(50) NOT  NULL comment '名称',
  link VARCHAR (254) not null comment '链接',
  logo varchar(254) not null comment 'logo 图片地址',
  description VARCHAR (50)  comment '描述文本',
  remark varchar(254) comment '备注',
  create_time timestamp null default current_timestamp comment '创建时间',
  modify_time timestamp null default current_timestamp on update current_timestamp comment '修改时间'
)