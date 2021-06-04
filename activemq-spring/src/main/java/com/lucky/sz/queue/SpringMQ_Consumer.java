package com.lucky.sz.queue;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @FileName: SpringMQ_Consumer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
@Service
public class SpringMQ_Consumer implements Serializable {


    @Autowired
    private JmsTemplate jmsTemplate;
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-activemq.xml");
        SpringMQ_Consumer springMQ_consumer = applicationContext.getBean(SpringMQ_Consumer.class);
        String returnValue = (String) springMQ_consumer.jmsTemplate.receiveAndConvert();
        System.out.println("****消费者收到的消息:   " + returnValue);
    }

}
