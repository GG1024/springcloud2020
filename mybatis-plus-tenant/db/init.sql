CREATE TABLE sys_user(
    id bigint PRIMARY KEY COMMENT '主键ID',
    account varchar(64) COMMENT '账号',
    tenant_id bigint COMMENT '租户ID'
) COMMENT = '用户表',
CHARACTER SET utf8,
COLLATE utf8_general_ci;

INSERT INTO demo.sys_user (id,account,tenant_id) VALUES
(1,'admin',1),
(2,'lisi',1),
(3,'wangwu',2);