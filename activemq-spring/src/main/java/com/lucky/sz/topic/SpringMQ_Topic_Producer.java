package com.lucky.sz.topic;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import java.io.Serializable;

/**
 * @FileName: SpringMQ_Producer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
@Service
public class SpringMQ_Topic_Producer implements Serializable {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-activemq.xml");
        SpringMQ_Topic_Producer springMQ_producer = applicationContext.getBean(SpringMQ_Topic_Producer.class);
        //直接调用spring-activemq.xml里面创建的destinationTopic这个bean设置为目的地就行了
        springMQ_producer.jmsTemplate.setDefaultDestination((Destination) applicationContext.getBean("destinationTopic"));
        springMQ_producer.jmsTemplate.send(session -> session.createTextMessage("***Spring和ActiveMQ的整合case2222....."));

        System.out.println("********send task over");

    }

}
