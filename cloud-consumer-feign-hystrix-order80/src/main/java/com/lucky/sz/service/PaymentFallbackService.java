package com.lucky.sz.service;

import org.springframework.stereotype.Component;

/**
 * @FileName: PaymentFallbackService.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-22
 **/
@Component
public class PaymentFallbackService implements PaymentFeignService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "----PaymentFallbackService fall back paymentInfo_Timeout,o(╥﹏╥)o";

    }
}
