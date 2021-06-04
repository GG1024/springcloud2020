package workquene;

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
public class Consumer2 implements Serializable {


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
        //参数1:是否持久化,参数2:是否独占队列,参数3:是否自动删除
        channel.queueDeclare("hello", true, false, false, null);
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者2:"+new String(body));
            }
        });


    }


}
