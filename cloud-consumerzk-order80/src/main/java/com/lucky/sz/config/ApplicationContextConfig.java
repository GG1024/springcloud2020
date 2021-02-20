package com.lucky.sz.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

/**
 * @FileName: ApplicationContextConfig.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-19
 **/
@Configuration
public class ApplicationContextConfig implements Serializable {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return  new RestTemplate();
    }

}
