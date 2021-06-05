package com.lucky.sz.tenant.sys.controller;

import com.lucky.sz.tenant.sys.entity.SysUserEntity;
import com.lucky.sz.tenant.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author weicong
 * @version 1.0 createTime 2021-02-22 18:21
 */
@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询用户列表
     *
     * @return
     */
    @PostMapping("/queryList")
    public List<SysUserEntity> queryList() {
        return sysUserService.queryList();
    }
}
