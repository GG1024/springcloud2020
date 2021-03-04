package com.lucky.sz.queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

/**
 * @FileName: Queue_Producer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
@Component
public class Queue_Producer implements Serializable {


    //Jms模板
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //队列目的地
    @Autowired
    private ActiveMQQueue activeMQQueue;


    //发送消息的方法
    public void sendProducerMessage() {
        jmsMessagingTemplate.convertAndSend(activeMQQueue, "**************" + UUID.randomUUID().toString());
    }

    //构造注入是构建对象
    public Queue_Producer(JmsMessagingTemplate jmsTemplate, ActiveMQQueue activeMQQueue) {
        this.jmsMessagingTemplate = jmsTemplate;
        this.activeMQQueue = activeMQQueue;
    }


    //间隔3秒，定时执行向服务发送一条消息
    @Scheduled(fixedDelay = 3000)
    public void producerMsgScheduled(){
        jmsMessagingTemplate.convertAndSend(activeMQQueue, "**************Scheduled" + UUID.randomUUID().toString());
        System.out.println("Scheduled定时投递");
    }
}
