package com.lucky.sz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

/**
 * @FileName: StreamMQMain8802.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-24
 **/
@SpringBootApplication
public class StreamMQMain8802 implements Serializable {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8802.class, args);
    }
}
