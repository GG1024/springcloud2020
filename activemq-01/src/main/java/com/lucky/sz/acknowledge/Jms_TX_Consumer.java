package com.lucky.sz.acknowledge;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * @FileName: Jms_TX_Producer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
public class Jms_TX_Consumer implements Serializable {

    private static final String ACTIVEMQ_URL = "tcp://192.168.92.129:61616";
    private static final String ACTIVEMQ_QUEUE_NAME = "queue-ACK";


    public static void main(String[] args) throws JMSException, IOException {

        /*
         * 非事务下消费者如何实现手动签收
         *
         * */

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        Queue queue = session.createQueue(ACTIVEMQ_QUEUE_NAME);

        MessageConsumer messageConsumer = session.createConsumer(queue);

        messageConsumer.setMessageListener(message -> {
            if (message instanceof TextMessage) {
                try {

                    TextMessage textMessage = (TextMessage) message;
                    System.out.println("***消费者接收到的消息:   " + textMessage.getText());
                    /*
                     * session设置为CLIENT_ACKNOWLEDGE 手动签收，要调用acknowledge（）该方法，标识该消息已被消费。
                     * 如果不调用，该消息的标识还是未消费，下次启动消费者，或者其他消费者还会消费到该消息
                     */
                    textMessage.acknowledge();
                } catch (Exception e) {
                    System.out.println("出现异常，消费失败，放弃消费");
                }
            }
        });

        System.in.read();

        messageConsumer.close();
        session.commit();
        connection.close();
    }
}
