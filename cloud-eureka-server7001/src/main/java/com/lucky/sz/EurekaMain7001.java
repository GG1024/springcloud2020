package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.io.Serializable;

/**
 * @FileName: EurekaMain7001.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-19
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 implements Serializable {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);
    }

}
