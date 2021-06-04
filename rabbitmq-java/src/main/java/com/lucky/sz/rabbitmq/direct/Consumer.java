package com.lucky.sz.rabbitmq.direct;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {


    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // 1.创建连接工厂
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("192.168.72.129");
            connectionFactory.setPort(5672);
            connectionFactory.setUsername("admin");
            connectionFactory.setPassword("admin");
            connectionFactory.setVirtualHost("my_vhost");
            // 获取队列的名称
            final String queueName = Thread.currentThread().getName();
            Connection connection = null;
            Channel channel = null;
            try {
                // 2.创建连接connection
                connection = connectionFactory.newConnection("生产者");
                // 3.通过连接获取通道 channel
                channel = connection.createChannel();
                // 4.通过通道创建交换机，声明队列，绑定关系，路由key,发送消息，接受消息
                Channel finalChannel = channel;
                finalChannel.basicConsume(queueName, true, new DeliverCallback() {
                    @Override
                    public void handle(String s, Delivery message) throws IOException {
                        System.out.println(message.getEnvelope().getDeliveryTag());
                        System.out.println("收到消息是：" + new String(message.getBody(), "UTF-8"));
                    }
                }, new CancelCallback() {
                    @Override
                    public void handle(String s) throws IOException {
                        System.out.println("接受失败.....");
                    }
                });
                System.out.println(queueName + "开始接受消息....");
                System.in.read();
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
    };

    public static void main(String[] args) {
        new Thread(runnable, "queue1").start();
        new Thread(runnable, "queue2").start();
        new Thread(runnable, "queue3").start();
    }
}