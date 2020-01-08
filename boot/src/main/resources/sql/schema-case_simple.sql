use spring_boot_plus;
DROP TABLE IF EXISTS case_simple;
CREATE TABLE case_simple
(
    recordnumber VARCHAR(18) NOT NULL COMMENT '记录号，主键ID',
    ADDRESS VARCHAR(250) NULL DEFAULT NULL COMMENT '点位',
    discoverway INT(11) NOT NULL DEFAULT 1 COMMENT '渠道来源',
    a_street INT(11) NULL COMMENT '街道',
    record_date TIMESTAMP NULL COMMENT '记录时间',
    region INT(11)  NULL COMMENT '城区',
    match_ID INT(11) NULL DEFAULT NULL COMMENT '执法情况',
    Approval_progress_a INT(11) NULL DEFAULT NULL COMMENT '审批进展',
    Approval_progress_b INT(11) NULL DEFAULT NULL COMMENT '审批进展',
    addr_map VARCHAR(15) NULL COMMENT '地图坐标',
    PRIMARY KEY (RECORDNUMBER)
);
