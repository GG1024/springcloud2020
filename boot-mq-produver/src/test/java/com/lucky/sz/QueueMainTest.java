package com.lucky.sz;

import com.lucky.sz.queue.Queue_Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

/**
 * @FileName: QueueMainTest.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
@SpringBootTest(classes = QueueMain.class)
@RunWith(SpringRunner.class)
public class QueueMainTest implements Serializable {

    @Autowired
    private Queue_Producer queue_producer;

    @Test
    public void producer_message() {
        queue_producer.sendProducerMessage();
    }

}
