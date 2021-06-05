package com.lucky.sz.tenant.sys.service;

import com.lucky.sz.tenant.sys.entity.SysUserEntity;

import java.util.List;

/**
 * 用户-业务层接口
 *
 * @author weicong
 * @version 1.0 createTime 2021-02-22 18:15
 */
public interface SysUserService {

    /**
     * 查询用户列表
     *
     * @return
     */
    List<SysUserEntity> queryList();

    /**
     * 添加
     *
     * @param sysUserEntity
     */
    void add(SysUserEntity sysUserEntity);

    /**
     * 修改
     *
     * @param sysUserEntity
     */
    void update(SysUserEntity sysUserEntity);

    /**
     * 通过id删除
     *
     * @param id
     */
    void deleteById(Long id);
}
