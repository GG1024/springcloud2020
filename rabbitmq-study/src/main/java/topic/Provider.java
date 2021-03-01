package topic;

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
        //声明交换机
        channel.exchangeDeclare("topics","topic");
        String toutingKey = "user.save.modify";

        //发布消息
        channel.basicPublish("topics",toutingKey,null,("这是路由中的动态订阅模型,route key: ["+toutingKey+"]").getBytes());

        channel.close();
        connection.close();

    }
}
