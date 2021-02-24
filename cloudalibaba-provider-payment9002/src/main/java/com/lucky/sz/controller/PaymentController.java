package com.lucky.sz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @FileName: PaymentController.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-24
 **/
@RestController
public class PaymentController implements Serializable {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "Hello Nacos Discovery: " + serverPort + "\t id: " + id;
    }


}
