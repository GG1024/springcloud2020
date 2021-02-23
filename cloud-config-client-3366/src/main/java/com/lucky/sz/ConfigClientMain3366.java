package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.Serializable;

/**
 * @FileName: ConfigClientMain3366.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-23
 **/
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366 implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3366.class, args);
    }

}
