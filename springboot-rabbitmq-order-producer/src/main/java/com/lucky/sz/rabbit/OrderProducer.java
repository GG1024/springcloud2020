package com.lucky.sz.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

/**
 * @FileName: OrderProducer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-06-05
 **/
@SpringBootApplication
public class OrderProducer implements Serializable {
    public static void main(String[] args) {
        SpringApplication.run(OrderProducer.class, args);
    }

}
