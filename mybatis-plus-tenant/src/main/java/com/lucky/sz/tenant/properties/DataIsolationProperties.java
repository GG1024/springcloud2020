package com.lucky.sz.tenant.properties;

import com.alibaba.druid.util.JdbcConstants;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "data-isolation")
@RefreshScope
public class DataIsolationProperties {
    /**
     * 数据隔离方言
     */
    private String dialect = JdbcConstants.MYSQL;

    /**
     * 数据隔离表集合
     */
    private List<String> tableNames = Arrays.asList("uc_staff", "uc_dept", "uc_sys_role");

    /**
     * 数据隔离字段
     */
    private String tenantIdField = "org_id";

}
