package com.lucky.sz.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * @FileName: JmsProducerSchedule.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-05
 **/
public class JmsConsumerSchedule implements Serializable {


    private static final String ACTIVEMQ_URL = "nio://192.168.92.129:61618";
    private static final String TOPIC_NAME = "Queue-延迟投递";

    public static void main(String[] args) throws JMSException, IOException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(TOPIC_NAME);

        MessageConsumer messageConsumer = session.createConsumer(queue);

        messageConsumer.setMessageListener(message -> {
            if (message instanceof TextMessage) {
                try {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println("*******消费者接收的消息是：" + textMessage.getText());
                } catch (JMSException e) {
                    System.out.println("出现异常，消费失败，放弃消费");
                }
            }
        });
        System.in.read();
        //9.关闭消费者资源
        messageConsumer.close();
        session.close();
        connection.close();

    }

}
