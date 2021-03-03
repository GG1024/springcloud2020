package com.lucky.sz.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;

/**
 * @FileName: JmsProduce.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-03
 **/
public class JmsProduce implements Serializable {



    private static final String ACTIVEMQ_URL = "tcp://192.168.92.129:61616";
    private static final String QUEUE_NAME = "jdbc01";


    public static void main(String[] args) throws JMSException {


        //1.创建连接工厂，按照给定的连接URL，默认的用户密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        //2.通过连接工厂，获取connection连接启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        //3.创建session会话
        //两个参数，transacted =事务，acknowledgeMode=确认，签收模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地，确定是队列还是主题
        Queue queue = session.createQueue(QUEUE_NAME);
        // 5.创建消息的生产者
        MessageProducer messageProducer = session.createProducer(queue);
        messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        for (int i = 1; i < 4 ; i++) {
            TextMessage textMessage = session.createTextMessage("---MessageListener---" + i);
            messageProducer.send(textMessage);
        }

        messageProducer.close();
        session.close();
        connection.close();

    }

}
