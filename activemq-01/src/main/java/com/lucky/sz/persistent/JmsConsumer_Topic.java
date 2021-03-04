package com.lucky.sz.persistent;

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
public class JmsConsumer_Topic implements Serializable {

    private static final String ACTIVEMQ_URL = "tcp://192.168.92.129:61616";
    private static final String TOPIC_NAME = "Topic-Persist";

    public static void main(String[] args) throws JMSException, IOException {
        //1.创建连接工厂，按照给定的URL，采用默认的用户名密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2.通过连接工厂,获得connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        //设置客户端ID，想MQ服务器注册自己的名称
        connection.setClientID("marry");
        //3.创建会话session
        //两个参数transacted=事务,acknowledgeMode=确认模式(签收)
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地(具体是队列queue还是主题topic)
        Topic topic = session.createTopic(TOPIC_NAME);

        //创建一个topic 订阅对象，一参是topic，二参是订阅者名称
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic,"remark...");
        //设置订阅之后再启动连接
        connection.start();


        //5.创建消息的消费者,指定消费哪一个队列里面的消息
        topicSubscriber.setMessageListener(message -> {
            if (message instanceof TextMessage){
                try {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println("****消费者text的消息："+textMessage.getText());
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
