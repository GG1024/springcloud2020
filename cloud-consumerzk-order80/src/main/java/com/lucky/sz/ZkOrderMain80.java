package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.Serializable;

/**
 * @FileName: OrderMain80.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-19
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ZkOrderMain80 implements Serializable {
    public static void main(String[] args) {
        SpringApplication.run(ZkOrderMain80.class, args);
    }

}
