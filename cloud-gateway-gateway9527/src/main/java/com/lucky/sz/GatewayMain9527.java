package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.Serializable;

/**
 * @FileName: GatewayMain9527.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-22
 **/
@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class GatewayMain9527 implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class, args);
    }

}
