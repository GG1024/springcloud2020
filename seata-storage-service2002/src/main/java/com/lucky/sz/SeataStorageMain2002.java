package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.Serializable;

/**
 * @FileName: SeataOrderMain2001.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-25
 **/

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class SeataStorageMain2002 implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMain2002.class,args);
    }

}
