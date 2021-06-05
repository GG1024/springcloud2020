package com.lucky.sz.tenant.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 字典-实体类
 * @author weicong
 * @version 1.0 createTime 2021-02-22 17:56
 */
@TableName("sys_user")
@Data
public class SysUserEntity {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 账号
     */
    @TableField("account")
    private String account;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private Long tenantId;
}
