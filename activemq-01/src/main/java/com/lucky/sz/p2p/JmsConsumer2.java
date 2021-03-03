package com.lucky.sz.p2p;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * @FileName: JmsConsumer2.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-03
 **/
public class JmsConsumer2 implements Serializable {


    private static final String ACTIVEMQ_URL = "tcp://192.168.92.129:61616";
    private static final String QUEUE_NAME = "queue01";

    public static void main(String[] args) throws JMSException, IOException {
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

        //通过监听的方式消费消息
        /**
         *
         * 异步非阻塞式监听器-onMessage
         *  订阅者或消费者通过创建的消费者对象，给消费者注册监听器setMessageListener
         *  当消息队列有消息的时候，系统会自动调用MessageListener类的onMessage方法
         *  我们只需要在onMessage方法内判断消息类型即可
         *
         * */

        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message!=null&& message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("*******消费者接收到的消息是：" + textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        //保证控制台不关闭，阻止程序关闭
        System.in.read();

        //关闭资源
        messageConsumer.close();
        session.close();
        connection.close();

    }


}
