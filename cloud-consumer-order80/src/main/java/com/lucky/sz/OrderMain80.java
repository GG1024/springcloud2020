package com.lucky.sz;

import com.lucky.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import java.io.Serializable;

/**
 * @FileName: OrderMain80.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-19
 **/
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 implements Serializable {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

}
