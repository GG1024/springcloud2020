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
public class JmsProduce implements Serializable {


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
            //这里指定传递的消息目的地
            textMessage.setJMSDestination(topic);
            /*
             * 持久模式和非持久模式
             * 1：DeliveryMode.NON_PERSISTENT 非持久
             * 2：DeliveryMode.PERSISTENT 持久
             * 一条持久性的消息，应该被传送“一次仅仅一次”意味着如果jms提供者出现故障，该消息并不会丢失，他会在服务器恢复之后再次传递
             * 一条非持久的消息，最多会传递一次，意味着服务器出现故障，该消息将会永远丢失。
             */
            textMessage.setJMSDeliveryMode(DeliveryMode.PERSISTENT);

            /*
             *设置消息的过期时间，默认永不过期
             * 消息过期时间，等于Destination的send方法中timeToLive值加上发送时刻GMT时间值
             * 如果timeToLive等于0，则JMSException被设为0，表示该消息用不过期
             * 如果发送后，在过期时间后还没有发送到目的地，则该消息被清除。
             */
            textMessage.setJMSExpiration(1000);
            /*
             * 消息优先级，0-9十个级别，0-4普通消息，5-9加急消息
             * JMS规范不严格要求mq按照这十个级别去发送消息，但必须保证加急消息优先于普通消息，默认级别是4
             */
            textMessage.setJMSPriority(10);
            /*
             *唯一标识每个消息的标识，MQ默认生成，也可自己指定
             */
            textMessage.setJMSMessageID("ABCD");


            //8.使用指定好目的地的消息生产者发送消息
            messageProducer.send(textMessage);
        }
        //9.关闭资源
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("****TOPIC_NAME消息发布到MQ完成");


    }


}
