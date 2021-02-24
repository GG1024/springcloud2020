package com.lucky.sz.controller;

import com.lucky.sz.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @FileName: SendMessageController.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-24
 **/

@RestController
public class SendMessageController implements Serializable {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProvider.send();
    }
}
