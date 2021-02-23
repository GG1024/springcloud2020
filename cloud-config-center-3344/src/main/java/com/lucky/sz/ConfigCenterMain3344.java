package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.io.Serializable;

/**
 * @FileName: ConfigCenterMain3344.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-23
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 implements Serializable {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
