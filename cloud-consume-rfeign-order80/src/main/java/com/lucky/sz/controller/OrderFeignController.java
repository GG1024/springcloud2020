package com.lucky.sz.controller;

import com.lucky.sz.common.CommonResult;
import com.lucky.sz.entity.Payment;
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

    public static final String PAYMENT_URL = "http://localhost:8001";
    private static final String INVOKE_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        return paymentFeignService.paymentFeignTimeout();
    }
}
