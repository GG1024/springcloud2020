package com.lucky.sz.topics;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @FileName: TopicCustomer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-01
 **/
@Component
public class TopicCustomer implements Serializable {


    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue, key = {"user.*"}, exchange = @Exchange(type = "topic", name = "topics"))
    })
    public void message1(String message) {
        System.out.println("message1 = " + message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue, key = {"user.#"}, exchange = @Exchange(type = "topic", name = "topics"))
    })
    public void message2(String message) {
        System.out.println("message2 = " + message);
    }

}
