package com.lucky.sz.tenant.sys.service.impl;

import com.lucky.sz.tenant.sys.entity.SysUserEntity;
import com.lucky.sz.tenant.sys.mapper.SysUserMapper;
import com.lucky.sz.tenant.sys.service.SysUserService;
import com.lucky.sz.tenant.util.LoginUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户-业务层接口实现类
 * @author weicong
 * @version 1.0 createTime 2021-02-22 18:17
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUserEntity> queryList() {
        return sysUserMapper.selectList(null);
    }

    @Override
    public void add(SysUserEntity sysUserEntity) {
        sysUserEntity.setTenantId(LoginUserUtils.getTenantId());
        sysUserMapper.insert(sysUserEntity);
    }

    @Override
    public void update(SysUserEntity sysUserEntity) {
        sysUserMapper.updateById(sysUserEntity);
    }

    @Override
    public void deleteById(Long id) {
        sysUserMapper.deleteById(id);
    }
}
