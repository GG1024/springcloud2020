package com.lucky.sz.service;

/**
 * @FileName: OrderService.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-03-01 17:19
 **/
public interface OrderService {
    Integer createOrder(Integer id);

    String getMd5(Integer id, Integer userid);

    Integer kill(Integer id, Integer userId, String md5);
}
