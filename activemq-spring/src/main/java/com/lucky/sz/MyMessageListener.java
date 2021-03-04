package com.lucky.sz;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.Serializable;

/**
 * @FileName: MyMessageListener.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/
@Component
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            try {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("监听器接受消息："+textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
