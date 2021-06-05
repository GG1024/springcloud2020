package com.lucky.sz.tenant.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lucky.sz.tenant.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户-数据层
 *
 * @author weicong
 * @version 1.0 createTime 2021-02-22 17:58
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
}
