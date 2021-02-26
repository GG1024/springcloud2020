package com.lucky.sz.controller;

import com.lucky.sz.common.CommonResult;
import com.lucky.sz.domain.Order;
import com.lucky.sz.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @FileName: OrderController.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-25
 **/
@RestController
public class OrderController implements Serializable {

    @Resource
    private OrderService orderService;


    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }



}
