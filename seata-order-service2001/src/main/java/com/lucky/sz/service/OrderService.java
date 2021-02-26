package com.lucky.sz.service;

import com.lucky.sz.domain.Order;

/**
 * @FileName: OrderService.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-25 15:04
 **/
public interface OrderService {


    /**
     * 创建订单
     * @param order
     */
    void create(Order order);

}
