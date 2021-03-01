package com.lucky.sz.directs;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @FileName: DirectCustomer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-01
 **/
@Component
public class DirectCustomer implements Serializable {

    @RabbitListener(bindings ={
            @QueueBinding(
                    value = @Queue(),
                    key={"info","error"},
                    exchange = @Exchange(type = "direct",name="directs")
            )})
    public void receive1(String message){
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings ={
            @QueueBinding(
                    value = @Queue(),
                    key={"error"},
                    exchange = @Exchange(type = "direct",name="directs")
            )})
    public void receive2(String message){
        System.out.println("message2 = " + message);
    }


}
