# create database if not exists my_manage_server character set utf8mb4 COLLATE utf8mb4_general_ci;
#
# use my_manage_server;

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          bigint(20)   NOT NULL auto_increment COMMENT '主键',
    `username`    varchar(20)  NOT NULL COMMENT '用户名',
    `nickname`    varchar(20)       DEFAULT NULL COMMENT '昵称',
    `password`    varchar(64)  NOT NULL COMMENT '密码',
    `salt`        varchar(32)       DEFAULT NULL COMMENT '盐值',
    `phone`       varchar(20)  NULL COMMENT '手机号码',
    `gender`      int(11)      NULL DEFAULT '1' COMMENT '性别，0：女，1：男，默认1',
    `head`        varchar(200) null comment '头像',
    `remark`      varchar(200)      DEFAULT NULL COMMENT 'remark',
    `state`       int(11)      NULL DEFAULT '1' COMMENT '状态，0：禁用，1：启用，2：锁定',
    `role_id`     bigint(20)   NULL COMMENT '角色id',
    `deleted`     int(11)      NULL DEFAULT '0' COMMENT '逻辑删除，0：未删除，1：已删除',
    `create_time` timestamp         DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp    NULL DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='系统用户';



DROP TABLE IF EXISTS `User_Item`;
CREATE TABLE `User_Item`
(
    `id`         int(11)     NOT NULL auto_increment COMMENT '主键',
    `itemName`   varchar(20) NOT NULL COMMENT '项目名称',
    `address`    varchar(50),
    `userName`   varchar(20),
    `password`   varchar(50),
    `remark`     varchar(50) COMMENT '备注',
    `salt`       varchar(20),
    `typeNameId` int         NOT NULL COMMENT '类型',
    `userId`     int         NOT NULL COMMENT '用户的id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='系统用户';


DROP TABLE IF EXISTS `Room_Details`;
CREATE TABLE `Room_Details`
(
    `communityName` varchar(20) not null comment '小区名称',
    `roomNumber`    varchar(20) not null comment '房间号',
    `roomArea`      int(11)     default null,
    `electricMeter` varchar(20) default null comment '电表号',
    `waterMeter`    varchar(20) default null comment '水表号',
    `propertyPrice` int(11)     default null comment '物业费单价',
    `isDelete`      tinyint     default 0 comment '是否删除的房源',
    `recordId`      int(11)     default null comment '记录号',
    primary key (`roomNumber`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='系统用户';


DROP TABLE IF EXISTS `Rental_record`;
CREATE TABLE `Rental_record`
(
    `id`                  int(11)     not null auto_increment,
    `startDate`           date         default null comment '房租开始时间',
    `payMonth`            int(11)      default null comment '房租时长（月）',
    `paymentDate`         date         default null comment '付款日期',
    `totalMoney`          int(11)      default null comment '付款金额',
    `propertyCosts`       int(11)      default null comment '物业费单价',
    `isContainRealty`     tinyint      default 0 comment '房租包含物业费',
    `roomNumber`          varchar(20) not null comment '房间号',
    `realtyStartDate`     date         default null comment '物业费开始时间',
    `propertyTime`        int(11)      default null comment '物业费时长（月）',
    `manID`               int(11)      default null comment '用户id',
    `deposit`             int(11)      default null comment '押金',
    `monthlyRent`         int(11)      default null comment '月租金',
    `contractSigningDate` date         default null comment '签合同时间',
    `contractMonth`       int(11)      default null comment '合同期限（月）',
    `remarks`             varchar(100) default null,
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='系统用户';


DROP TABLE IF EXISTS `Person_Details`;
CREATE TABLE `Person_Details`
(
    `id`      int(11)     not null auto_increment,
    `name`    varchar(20) not null comment '姓名',
    `tel`     varchar(20)  default null,
    `cord`    varchar(20)  default null comment '证件号',
    `other`   varchar(100) default null,
    `company` varchar(50)  default null comment '公司',
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='系统用户';


DROP TABLE IF EXISTS `icon_details`;
CREATE TABLE `icon_details`
(
    `id`    int(11)     not null,
    `name`  varchar(20) not null comment '姓名',
    `icon`  varchar(10) default null,
    `color` varchar(10) default null,
    `type`  int(11)     default null,
    primary key (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='系统用户';