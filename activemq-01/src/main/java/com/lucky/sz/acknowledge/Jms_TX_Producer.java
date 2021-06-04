package com.lucky.sz.acknowledge;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;

/**
 * @FileName: Jms_TX_Producer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
public class Jms_TX_Producer implements Serializable {

    private static final String ACTIVEMQ_URL = "tcp://192.168.92.129:61616";
    private static final String ACTIVEMQ_QUEUE_NAME = "queue-ACK";


    public static void main(String[] args) throws JMSException {

        /*
         * 非事务下消费者如何实现手动签收
         *
         * */

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue(ACTIVEMQ_QUEUE_NAME);

        MessageProducer producer = session.createProducer(queue);

        try {
            for (int i = 0; i < 3; i++) {
                TextMessage textMessage = session.createTextMessage("tx msg--" + i);
                producer.send(textMessage);
            }
            System.out.println("消息发送完成");
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            producer.close();
            session.close();
            connection.close();
        }

    }
}
