package com.lucky.sz.transaction;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * @FileName: JmsConsumer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-03
 **/
public class JmsConsumer implements Serializable {


    private static final String ACTIVEMQ_URL = "tcp://192.168.92.129:61616";

    private static final String ACTIVEMQ_QUEUE_NAME = "queue-TX";

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        // 创建会话session，两个参数transacted=事务,acknowledgeMode=确认模式(签收)
        // 消费者开启了事务就必须手动提交，不然会重复消费消息
        final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(ACTIVEMQ_QUEUE_NAME);
        MessageConsumer messageConsumer = session.createConsumer(queue);
        messageConsumer.setMessageListener(new MessageListener() {
            int a = 0;

            @Override
            public void onMessage(Message message) {
                if (message instanceof TextMessage) {
                    try {
                        if (a == 2) {
                            System.out.println(1 / 0);
                        }
                        TextMessage textMessage = (TextMessage) message;
                        System.out.println("***消费者接收到的消息:   " + textMessage.getText());
                        session.commit();
                        a = a + 1;
                    } catch (Exception e) {
                        System.out.println("出现异常，消费失败，放弃消费");
                        try {
                            session.rollback();
                            a = 0;
                        } catch (JMSException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        //关闭资源
        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();

    }

}
