# drop database if exists wuhan_illegal_construction;
# create database wuhan_illegal_construction;
# use wuhan_illegal_construction;

# 创建案件基本信息表
DROP TABLE IF EXISTS case_simple;
CREATE TABLE case_simple
(
    record_number       VARCHAR(18)  NOT NULL COMMENT '记录号，主键ID' primary key,
    ADDRESS             VARCHAR(250) NULL     DEFAULT NULL COMMENT '点位',
    discover_way        TINYINT      NOT NULL DEFAULT 1 COMMENT '渠道来源',
    a_street            TINYINT      NULL COMMENT '街道,和UserInfo表中ID相对应',
    record_date         TIMESTAMP    NULL COMMENT '记录时间',
    region              TINYINT      NULL COMMENT '城区，和AppendInfo表中的Id相对应',
    match_ID            TINYINT      NULL     DEFAULT NULL COMMENT '执法情况',
    Approval_progress_a TINYINT      NULL     DEFAULT NULL COMMENT '审批进展',
    Approval_progress_b TINYINT      NULL     DEFAULT NULL COMMENT '审批进展',
    addr_map            VARCHAR(15)  NULL COMMENT '地图坐标'
);

# 创建案件详细信息表
DROP TABLE IF EXISTS case_desc;
CREATE TABLE case_desc
(
    record_number              VARCHAR(18)   NOT NULL COMMENT '记录号，主键ID' primary key,
    complainant                varchar(10)   not null comment '投诉人姓名',
    sex                        int           null default 0 comment '性别',
    complainant_Tel            varchar(15)   null comment '投诉人电话',
    auto_reply                 int                default 0 comment '自动回复投诉人',
    actual_Address             varchar(250)  null comment '实际投诉点位',
    is_true                    int                default 0 comment '是否属实',
    is_true_explain            varchar(250)  null comment '是否属实备注',
    illegal_construction_type  int                default 1 comment '违建类型',
    person_code                varchar(18)   null comment '个人身份证',
    enterprise_code            varchar(30)   null comment '企业证号',
    project_name               varchar(50)   null comment '项目名称',
    party                      varchar(50)   null comment '当事人或建设单位',
    point                      int           null default null comment '违建处数',
    Area_covered               float(6, 2)   null default null comment '占地面积',
    floor_num                  int           null default null comment '楼层数',
    built_up_area              float(6, 2)   null default null comment '建筑面积',
    building_date              timestamp     null default null comment '建设时间',
    is_load_pic                int                default null comment '是否上传照片',
    case_manage                varchar(10)   null default null comment '案件负责人',
    case_manage_Tel            varchar(15)   null default null comment '案件负责人电话',
    build_date_type            int           null default null comment '建设时间类型',
    build_type                 int           null default null comment '建设类型，地面、楼面、楼顶',
    build_Property             int           null default null comment '建设性质',
    build_area1                int           null default null comment '建设区域1',
    build_area2                int           null default null comment '建设区域2',
    Handling_Opinions          int           null default null comment '处置意见',
    Handling_Opinions_end_date timestamp     null default null comment '拟处置时限',
    Processing_Result          int                default null comment '处置情况、处理结果',
    handle_num                 int           null default null comment '处置处数',
    handle_floor_num           int           null default null comment '处置楼层数',
    handle_area                float(6, 2)   null default null comment '处置面积',
    handle_date                timestamp     null default null comment '处置时间',
    Execution_Mode             int           null default null comment '执行方式',
    remove_area                float(6, 2)   null default null comment '拆除面积',
    Amount_of_penalty          decimal(8, 2) null default null comment '处罚金额',
    Cannot_Over                int           null default null comment '未办结原因',
    save_date                  timestamp     null default null comment '保存时间',
    remark                     varchar(255)  null default null comment '备注',
    return_visit_date          timestamp     null default null comment '回访时间',
    return_visit_person_name   varchar(10)   null default null comment '回访人姓名',
    Complaints                 varchar(255)  null default null comment '投诉人意见',
    Complaints_remark          varchar(255)  null default null comment '投诉人意见备注',
    is_need_region_verify      int           null default null comment '是否需要区级审核',
    is_repeated_case           int           null default null comment '是否重复案件',
    repeated_case_main_Id      varchar(18)   null default null comment '主案ID号',
    region_verity_date         timestamp     null default null comment '区级审核时间',
    region_opinion             varchar(255)  null default null comment '区级意见',
    city_opinion               varchar(255)  null default null comment '市级意见',
    city_verity_date           timestamp     null default null comment '市级审核时间'
);


# 创建用户信息表
drop table if exists User_Info;
create table User_Info
(
#     id          TINYINT     not null AUTO_INCREMENT comment '用户ID，主键',
    name        varchar(15) not null comment '用户名',
    full_Name   varchar(20) not null comment '区或街道名称',
    power_Level TINYINT     not null default 1 comment '权限等级，1=街道，2=区，3=市，4=系统',
    region_Id   TINYINT     null comment '所属区ID',
    salt    varchar(10) null comment '加盐',
    password    varchar(80) not null comment '密码',
    primary key (name)
);

# 创建字典信息表
drop table if exists sys_dict;
create table sys_dict
(
    id    TINYINT     not null AUTO_INCREMENT comment '主键ID',
    item  TINYINT     not null comment '信息所属项序号',
    title varchar(20) not null comment '信息内容',
    primary key (id)
);

# 创建生成全局ID表
drop table if exists 'sequence';
CREATE TABLE `sequence`
(
    `name`  varchar(10) NOT NULL,
    `value` int(6) DEFAULT NULL,
    `next`  int(6) DEFAULT NULL,
    PRIMARY KEY (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
INSERT INTO `sequence`
VALUES ('trans_no', '0', '1');

# 获取5位唯一的数字，自定义函数
DROP FUNCTION IF EXISTS next_trans_num;
CREATE FUNCTION next_trans_num(seq_name varchar(20)) RETURNS varchar(50) charset utf8
BEGIN
    UPDATE sequence
    SET `value`=IF(LAST_INSERT_ID(value + next) >= 99998, 0, LAST_INSERT_ID(value + next))
    WHERE `name` = seq_name;
    return last_insert_id();
END;

# 获取8位日期+5位数字，自定义函数
DROP FUNCTION IF EXISTS get_trans_num;
CREATE FUNCTION get_trans_num() RETURNS varchar(20) charset utf8
BEGIN
    DECLARE getVal VARCHAR(24);
    SET getVal = (SELECT CONCAT(DATE_FORMAT(NOW(), '%Y%m%d'), LPAD((SELECT next_trans_num('trans_no')), 5, '0')));
    RETURN getVal;
# SELECT CONCAT(DATE_FORMAT(NOW(), '%Y%m%d%H%i')
END;

# 创建用户菜单表
drop table if exists sys_menu;
create table sys_menu
(
    id        int(11)      not null primary key auto_increment comment '主键',
    name      varchar(10)  not null comment '菜单名称',
    parent_id int(11)      not null default 0 comment '父菜单ID，一级菜单为0',
    url       varchar(100) null     default null comment '菜单的URL',
    perms     varchar(150) null     default null comment '授权，多个用逗号分隔，如sys:user:add,sys:user:edit',
    icon      varchar(150) null     default null comment '菜单图标'
) engine = innodb
  default charset = utf8 comment '菜单管理';