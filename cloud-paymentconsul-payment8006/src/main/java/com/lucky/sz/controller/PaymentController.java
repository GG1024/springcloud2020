package com.lucky.sz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-20 15:27
 **/
@Slf4j
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "springcloud with consul:" + serverPort + "\t"
                + UUID.randomUUID().toString();
    }


}
