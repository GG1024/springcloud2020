package com.lucky.sz.tenant.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.TreeSet;

/**
 * @author weicong
 * @version 1.0 createTime 2020-12-25 14:44
 */
@Data
@Component
@Configuration
public class TenantProperties {

    @Value("${system.tenant.enabled-tenant:false}")
    private boolean enabledTenant;

    @Value("${system.tenant.not-tenant-tables:null}")
    private TreeSet<String> notTenantIdTable;

}
