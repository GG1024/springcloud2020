package com.lucky.sz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @FileName: OrderDao.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-25 15:02
 **/
@Mapper
public interface AccountDao {
    /**
     * 扣减账户余额
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);


}
