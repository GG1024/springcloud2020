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



    private static final String ACTIVEMQ_URL = "nio://192.168.92.129:61616";
    private static final String QUEUE_NAME = "queue-nio";


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
        //特性：持久化
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for (int i = 1; i < 4 ; i++) {
            TextMessage textMessage = session.createTextMessage("---MessageListener---" + i);
            messageProducer.send(textMessage);
        }
        System.out.println("  **** 消息发送到MQ完成 ****");
        messageProducer.close();
        session.close();
        connection.close();

    }

}
