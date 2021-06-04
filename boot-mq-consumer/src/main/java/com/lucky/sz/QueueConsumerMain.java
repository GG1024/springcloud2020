package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

/**
 * @FileName: QueueConsumerMain.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
@SpringBootApplication
public class QueueConsumerMain implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(QueueConsumerMain.class, args);
    }

}
