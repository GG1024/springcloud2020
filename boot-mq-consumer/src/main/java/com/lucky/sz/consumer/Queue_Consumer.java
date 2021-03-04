package com.lucky.sz.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.Serializable;

/**
 * @FileName: Queue_Producer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
@Component
public class Queue_Consumer implements Serializable {
    @JmsListener(destination = "myQueueName")
    public  void receive(
            TextMessage textMessage
    ) throws JMSException {
        System.out.println(" ***  消费者收到消息  ***"+textMessage.getText());
    }
}
