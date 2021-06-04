package com.lucky.sz.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

    public static void main(String[] args) {
        // 1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.72.129");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("my_vhost");
        Connection connection = null;
        Channel channel = null;
        try {
            // 2.创建连接connection
            connection = connectionFactory.newConnection("生产者");
            // 3.通过连接获取通道 channel
            channel = connection.createChannel();
            // 4.通过通道创建交换机，声明队列，绑定关系，路由key,发送消息，接受消息
            String queueName = "queue001";
            /**
             * @params1 队列的名称
             * @params2 是否要持久化 Declare=false,持久化消息是否会存盘，非持久化=fakse,持久化=true ,非持久化会存盘,但是会随着服务器的重启会丢失。
             * @params3 排他性，是否独占队列
             * @params4 是否自动删除，随着最后一个消费者完毕消息以后是否把队列自动删除
             * @params5 携带一些附加参数
             */
            channel.queueDeclare(queueName, false, false, false, null);
            // 5.准备消息内容
            String message = "Hello xuexi MQ simple";
            // 6.发送消息给队列queue
            /**
             * @params1 交换机
             * @params2 队列，路由key
             * @params3 消息的状态控制
             * @params4 消息主体
             * 面试题：可以存在没有交换机的队列吗？
             */
            channel.basicPublish("", queueName, null, message.getBytes());
            System.out.printf("消息发送成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7.关闭连接
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // 8.关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
