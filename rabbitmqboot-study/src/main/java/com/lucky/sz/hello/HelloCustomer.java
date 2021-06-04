package com.lucky.sz.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @FileName: HelloCustomer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-01
 **/
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class HelloCustomer implements Serializable {
    @RabbitHandler
    public void receive1(String message) {
        System.out.println("message = " + message);
    }


}
