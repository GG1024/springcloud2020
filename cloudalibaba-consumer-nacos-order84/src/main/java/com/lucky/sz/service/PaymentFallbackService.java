package com.lucky.sz.service;

import com.lucky.sz.common.CommonResult;
import com.lucky.sz.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @FileName: PaymentFallbackService.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-25
 **/
@Component
public class PaymentFallbackService implements PaymentFeignService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult(444, "paymentSQL，exception内容： ");
    }
}
