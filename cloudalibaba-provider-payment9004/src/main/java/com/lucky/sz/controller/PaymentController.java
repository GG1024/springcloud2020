package com.lucky.sz.controller;

import com.lucky.sz.common.CommonResult;
import com.lucky.sz.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @FileName: PaymentController.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-24
 **/
@RestController
public class PaymentController implements Serializable {


    @Value("${server.port}")
    private  String serverPort;

    public static HashMap<Long, Payment> map = new HashMap<>();
    static {
        map.put(1L,new Payment(1L,"1111"));
        map.put(1L,new Payment(2L,"2222"));
        map.put(1L,new Payment(3L,"3333"));
    }


    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = map.get(id);
        CommonResult<Payment> result = new CommonResult<>(200,"from mysql,serverPort: " + serverPort,payment);
        return result;
    }



}
