package com.lucky.sz.pubsub;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;

/**
 * @FileName: JmsProduce.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-03
 **/
public class JmsProduce_Property implements Serializable {


    private static final String ACTIVEMQ_URL = "tcp://192.168.92.129:61616";
    private static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException {
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
        //5.创建消息的生产者
        MessageProducer messageProducer = session.createProducer(topic);
        //6.通过使用消息生产者,生产三条消息,发送到MQ的队列里面
        for (int i = 0; i < 6; i++) {
            //7.通过session创建消息
            TextMessage textMessage = session.createTextMessage("TOPIC_NAME---" + i);
            textMessage.setStringProperty("From", "ZhangSan@qq.com");
            textMessage.setByteProperty("Spec", (byte) 1);
            textMessage.setBooleanProperty("Invalide",true);
            messageProducer.send(textMessage);

        }
        //9.关闭资源
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("****TOPIC_NAME消息发布到MQ完成");


    }


}
