package com.lucky.sz.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.lucky.sz.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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


    //创建令牌桶实例
    private RateLimiter rateLimiter = RateLimiter.create(40);


    //秒杀方法
    @GetMapping("sale")
    public String sale(Integer id) {
        //System.out.println("秒杀商品的id = " + id);
        //加入令牌桶的限流措施
        if (!rateLimiter.tryAcquire(3, TimeUnit.SECONDS)) {
            log.info("抛弃请求: 抢购失败,当前秒杀活动过于火爆,请重试");
            return "抢购失败,当前秒杀活动过于火爆,请重试!";
        }
        try {
            //根据商品id创建订单,返回创建订单的id
            int orderId = orderService.createOrder(id);
            System.out.println("秒杀成功,orderId = " + orderId);
            return String.valueOf(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }


}
