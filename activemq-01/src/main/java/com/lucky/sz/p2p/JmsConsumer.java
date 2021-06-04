package com.lucky.sz.p2p;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;

/**
 * @FileName: JmsConsumer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-03
 **/
public class JmsConsumer implements Serializable {


    private static final String ACTIVEMQ_URL = "tcp://192.168.92.129:61616";
    private static final String QUEUE_NAME = "queue01";
    /** 阻塞式消费*/
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
        // 5.创建接收消息的消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);

        //6.通过消息生产者，产生三条消息，发送到mq的队列里
       while (true){
            //通过消费者调用方法获取队列的里面消息，发送的消息什么类型，接收的时候就转成什么类型
           TextMessage textMessage = (TextMessage) messageConsumer.receive();
           if (textMessage!=null){
               System.out.println("*******消费者接收的消息是："+textMessage.getText());
           }else{
               break;
           }

       }

        //9.关闭消费者资源
        messageConsumer.close();
        //10.关闭会话资源
        session.close();
        //关闭连接资源
        connection.close();

    }

}
