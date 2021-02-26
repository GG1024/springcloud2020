package com.lucky.sz.dao;

import com.lucky.sz.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @FileName: OrderDao.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-25 15:02
 **/
@Mapper
public interface OrderDao {
    /**
     * 1 新建订单
     *
     * @param order
     * @return
     */
    int create(Order order);

    /**
     * 2 修改订单状态,从0改为1
     *
     * @param userId
     * @param status
     * @return
     */
    int update(@Param("userId") Long userId, @Param("status") Integer status);
}
