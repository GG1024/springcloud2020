package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

/**
 * @FileName: TopicConsumerMain.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
@SpringBootApplication
public class TopicConsumerMain implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(TopicConsumerMain.class, args);
    }


}
