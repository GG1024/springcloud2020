package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.Serializable;

/**
 * @FileName: PaymentMain9001.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-24
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderMain84 implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain84.class, args);
    }

}
