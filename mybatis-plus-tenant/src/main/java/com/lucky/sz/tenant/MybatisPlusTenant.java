package com.lucky.sz.tenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

/**
 * @FileName: MybatisPlusTenant.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-06-05
 **/
@SpringBootApplication
public class MybatisPlusTenant implements Serializable {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusTenant.class, args);
    }
}
