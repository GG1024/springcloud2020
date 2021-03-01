package workquene;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 * @FileName: Provider.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-01
 **/
public class Provider implements Serializable {

    //生产消息
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
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
        channel.queueDeclare("hello",true,false,false,null);
        for (int i = 0; i <10 ; i++) {
            channel.basicPublish("","hello",null,(i+"=======>, 我是消息").getBytes());
        }

        channel.close();
        connection.close();

    }
}
