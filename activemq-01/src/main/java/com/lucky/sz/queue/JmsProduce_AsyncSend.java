package com.lucky.sz.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

import javax.jms.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @FileName: JmsProduce_AsyncSend.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-05
 **/
public class JmsProduce_AsyncSend implements Serializable {

    private static final String ACTIVEMQ_URL = "nio://192.168.92.129:61618";
    private static final String TOPIC_NAME = "Queue-异步投递回调";


    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        activeMQConnectionFactory.setUseAsyncSend(true);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(TOPIC_NAME);

        //向上转型
       ActiveMQMessageProducer activeMQMessageProducer = (ActiveMQMessageProducer) session.createProducer(queue);

        for (int i = 0; i <3 ; i++) {
            TextMessage textMessage = session.createTextMessage();
            textMessage.setJMSMessageID(UUID.randomUUID().toString()+"--------guigu");
            String jmsMessageId =  textMessage.getJMSMessageID();
            //使用ActiveMQMessageProducer的发送消息,可以创建回调
            activeMQMessageProducer.send(textMessage, new AsyncCallback() {
                @Override
                public void onSuccess() {
                    System.out.println(jmsMessageId + "发送成功");
                }

                @Override
                public void onException(JMSException e) {
                    System.out.println(jmsMessageId + "发送失败");
                }
            });

        }
        System.out.println("消息发送完成");
        activeMQMessageProducer.close();
        session.close();
        connection.close();

    }
}
