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
public class JmsConsumer_Topic_JDBC implements Serializable {

    private static final String ACTIVEMQ_URL = "nio://192.168.92.129:61618";
    private static final String TOPIC_NAME = "Topic-JdbcPersistence";

    public static void main(String[] args) throws JMSException, IOException {
        //1.创建连接工厂，按照给定的URL，采用默认的用户名密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工厂,获得connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.setClientID("我是消费者刘德华");
        //3.创建会话session
        //两个参数transacted=事务,acknowledgeMode=确认模式(签收)
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地(具体是队列queue还是主题topic)
        Topic topic = session.createTopic(TOPIC_NAME);
        //5.创建消息的消费者
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic,"我是消费者刘德华我要订阅吴彦祖的消息");
        connection.start();
        //5.创建消息的消费者,指定消费哪一个队列里面的消息
        topicSubscriber.setMessageListener(message -> {
            if (message instanceof TextMessage){
                try {
                    TextMessage textMessage = (TextMessage) message;
                    session.commit();
                    System.out.println("****刘德华收到的消息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        topicSubscriber.close();
        session.close();
        connection.close();

    }


}
