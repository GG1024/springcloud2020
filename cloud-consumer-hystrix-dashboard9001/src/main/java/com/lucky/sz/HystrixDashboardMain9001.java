package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import java.io.Serializable;

/**
 * @FileName: HystrixDashboardMain9001.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-22
 **/

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain9001 implements Serializable {


    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class, args);
    }
}
