package com.lucky.sz.service;

import com.lucky.sz.common.CommonResult;
import com.lucky.sz.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @FileName: PaymentFeignService.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-25 11:55
 **/
@Component
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentFeignService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
