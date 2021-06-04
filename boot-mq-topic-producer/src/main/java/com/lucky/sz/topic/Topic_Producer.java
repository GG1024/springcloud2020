package com.lucky.sz.topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

/**
 * @FileName: Topic_Producer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
@Component
@EnableScheduling
public class Topic_Producer implements Serializable {


    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private ActiveMQTopic activeMQTopic;

    public Topic_Producer(JmsMessagingTemplate jmsTemplate, ActiveMQTopic activeMQTopic) {
        this.jmsMessagingTemplate = jmsTemplate;
        this.activeMQTopic = activeMQTopic;
    }


    //间隔3秒，定时执行向服务发送一条消息
    @Scheduled(fixedDelay = 3000)
    public void producerMsgScheduled() {
        jmsMessagingTemplate.convertAndSend(activeMQTopic, "**************Scheduled" + UUID.randomUUID().toString());
        System.out.println("Scheduled定时向topic投递");
    }


}
