package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.Serializable;

/**
 * @FileName: QueueMain.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
@SpringBootApplication
@EnableScheduling
public class QueueMain implements Serializable {
    public static void main(String[] args) {
        SpringApplication.run(QueueMain.class, args);
    }
}
