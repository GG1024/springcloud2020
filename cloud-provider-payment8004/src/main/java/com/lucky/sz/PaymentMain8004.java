package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.Serializable;

/**
 * @FileName: PaymentMain8004.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-20
 **/
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentMain8004 implements Serializable {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
