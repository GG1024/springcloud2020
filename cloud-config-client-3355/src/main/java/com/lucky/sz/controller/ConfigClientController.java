package com.lucky.sz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @FileName: ConfigClientController.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-23
 **/
@RestController
@RefreshScope
public class ConfigClientController implements Serializable {

    @Value("${version}")
    private String version;


    @GetMapping("/version")
    public String version() {
        return version;
    }

}
