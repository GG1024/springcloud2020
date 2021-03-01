package fanout;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 * @FileName: Consumer.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-01
 **/
public class Consumer3 implements Serializable {


    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.92.129");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/vhost_study");
        Connection connection = connectionFactory.newConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //绑定交换机
        channel.exchangeDeclare("logs", "fanout");
        //创建临时队列
        String queue = channel.queueDeclare().getQueue();
        //将队列绑定交换机
        channel.queueBind(queue,"logs","");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者3:"+new String(body));
            }
        });


    }


}
