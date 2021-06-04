package com.lucky.sz.queue;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @FileName: SpringMQ_Producer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
@Service
public class SpringMQ_Producer implements Serializable {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-activemq.xml");
        SpringMQ_Producer springMQ_producer = applicationContext.getBean(SpringMQ_Producer.class);

        springMQ_producer.jmsTemplate.send(session -> session.createTextMessage("***Spring和ActiveMQ的整合case111....."));

        System.out.println("********send task over");

    }

}
