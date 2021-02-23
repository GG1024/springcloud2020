package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.Serializable;

/**
 * @FileName: ConfigClientMain3355.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-23
 **/
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class, args);
    }

}
