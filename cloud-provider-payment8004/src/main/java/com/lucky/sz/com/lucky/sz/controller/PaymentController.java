package com.lucky.sz.com.lucky.sz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.UUID;

/**
 * @FileName: PaymentController.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-20
 **/
@RestController
@Slf4j
public class PaymentController implements Serializable {
    @Value("${server.port}")
    private String serverPort;


    @RequestMapping(value = "/payment/zk")
    public String paymentzk() {
        return "springcloud with zookeeper:" + serverPort + "\t"
                + UUID.randomUUID().toString();
    }


}
