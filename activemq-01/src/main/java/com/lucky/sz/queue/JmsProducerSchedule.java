package com.lucky.sz.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;
import java.io.Serializable;

/**
 * @FileName: JmsProducerSchedule.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-05
 **/
public class JmsProducerSchedule implements Serializable {


    private static final String ACTIVEMQ_URL = "nio://192.168.92.129:61618";
    private static final String TOPIC_NAME = "Queue-延迟投递";

    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(TOPIC_NAME);

        MessageProducer messageProducer = session.createProducer(queue);
        long delay = 10 * 1000;      //延迟投递的时间
        long period = 5 * 1000;     //每次投递的时间间隔
        int repeat = 5;                     //投递的次数

        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("message-延时投递" + i);
            // 延迟的时间
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
            // 重复投递的时间间隔
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, period);
            // 重复投递的次数
            textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeat);
            // 此处的意思：该条消息，等待10秒，之后每5秒发送一次，重复发送3次。
            messageProducer.send(textMessage);
        }

        System.out.println("延时投递消息完成");
        messageProducer.close();
        session.close();
        connection.close();

    }

}
