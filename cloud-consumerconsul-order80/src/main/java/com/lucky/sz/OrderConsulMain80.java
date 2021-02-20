package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.Serializable;

/**
 * @FileName: OrderConsulMain80.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-20
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 implements Serializable {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }

}
