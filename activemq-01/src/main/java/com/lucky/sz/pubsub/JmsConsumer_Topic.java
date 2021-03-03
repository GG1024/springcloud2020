package com.lucky.sz.pubsub;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * @FileName: JmsConsumer_Topic.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-03
 **/
public class JmsConsumer_Topic implements Serializable {

    private static final String ACTIVEMQ_URL = "tcp://192.168.92.129:61616";
    private static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("我是1号消费者");
        //1.创建连接工厂，按照给定的URL，采用默认的用户名密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工厂,获得connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3.创建会话session
        //两个参数transacted=事务,acknowledgeMode=确认模式(签收)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地(具体是队列queue还是主题topic)
        Topic topic = session.createTopic(TOPIC_NAME);
        //5.创建消息的消费者
        MessageConsumer messageConsumer = session.createConsumer(topic);
        //5.创建消息的消费者,指定消费哪一个队列里面的消息
        messageConsumer.setMessageListener(message -> {
            if (message instanceof TextMessage){
                try {
                    String text = ((TextMessage) message).getText();
                    System.out.println("****消费者text的消息："+text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
            if (message instanceof MapMessage){
                try {
                   MapMessage mapMessage = (MapMessage) message;
                    System.out.println("****消费者Map的消息："+mapMessage.getString("name"));
                    System.out.println("****消费者Map的消息："+mapMessage.getString("age"));
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();

        messageConsumer.close();
        session.close();
        connection.close();

    }


}
