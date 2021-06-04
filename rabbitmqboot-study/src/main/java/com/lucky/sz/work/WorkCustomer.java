package com.lucky.sz.work;

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
public class WorkCustomer implements Serializable {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String message){
        System.out.println("work message1 = " + message);
    }
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message){
        System.out.println("work message2 = " + message);
    }


}
