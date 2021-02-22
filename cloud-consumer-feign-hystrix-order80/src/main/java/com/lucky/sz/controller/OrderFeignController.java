package com.lucky.sz.controller;

import com.lucky.sz.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @FileName: OrderController.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-19
 **/
@RestController
@Slf4j
public class OrderFeignController implements Serializable {


    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        return paymentFeignService.paymentInfo_Timeout(id);
    }
}
