package com.lucky.sz.persistent;


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
    private static final String QUEUE_NAME = "queue01";

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
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        //6.通过消息生产者，产生三条消息，发送到mq的队列里
        for (int i = 0; i <3 ; i++) {
            //7 创建message消息内容
            TextMessage textMessage = session.createTextMessage("msg ---- messageListener");
            //8 通过messageProducer 发送消息到队列
            messageProducer.send(textMessage);
        }

        //9.关闭生产者资源
        messageProducer.close();
        //10.关闭会话资源
        session.close();
        //关闭连接资源
        connection.close();
        System.out.println("****消息发布到MQ队列完成");

    }




}
