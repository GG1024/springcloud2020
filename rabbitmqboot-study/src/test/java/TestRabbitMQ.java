import com.lucky.sz.RabbitmqBootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @FileName: TestRabbitMQ.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-01
 **/
@SpringBootTest(classes = RabbitmqBootApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ implements Serializable {


    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testHello() {
        rabbitTemplate.convertAndSend("hello","hello,world");
    }


    @Test
    public void testWork() {
        for (int i = 0; i <9 ; i++) {
            rabbitTemplate.convertAndSend("work","hello,work");
        }

    }


    @Test
    public void testFanout() throws InterruptedException {
        rabbitTemplate.convertAndSend("logs","","这是日志广播");
    }


    @Test
    public void testDirect(){
        rabbitTemplate.convertAndSend("directs","error","error 的日志信息");
    }


    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save.findAll","user.save.findAll 的日志信息");
    }
}
