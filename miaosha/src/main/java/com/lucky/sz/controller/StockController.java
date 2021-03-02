package com.lucky.sz.controller;

import com.lucky.sz.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-03-01 17:35
 **/
@Slf4j
@RestController
public class StockController {


    @Resource
    private OrderService orderService;

    //秒杀方法
    @GetMapping("sale")
    public String sale(Integer id){
        int orderId = 0;
        try{
            synchronized (this){
                //根据商品id创建订单,返回创建订单的id
                orderId =  orderService.createOrder(id);
            }
            System.out.println("orderId = " + orderId);
            return String.valueOf(orderId);
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }


}
