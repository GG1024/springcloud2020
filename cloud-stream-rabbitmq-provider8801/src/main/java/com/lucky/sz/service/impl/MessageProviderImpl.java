package com.lucky.sz.service.impl;

import com.lucky.sz.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @FileName: MessageProviderImpl.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-24
 **/
@EnableBinding(Source.class)//定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {

        String uuid  = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("**********uuid: "+uuid);
        return null;
    }
}
