package com.lucky.sz.dao;

import com.lucky.sz.domain.StockOrder;
import org.apache.ibatis.annotations.Mapper;

/**
 * @FileName: OrderDAO.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-03-01 17:16
 **/
@Mapper
public interface OrderDAO {
    //创建订单
    void createOrder(StockOrder stockOrder);
}
