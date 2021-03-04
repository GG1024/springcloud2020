package com.lucky.sz.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import java.io.Serializable;

/**
 * @FileName: ActiveMQConfigBean.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-04
 **/

/**
 * 设置持久化订阅
 */
@Component
public class ActiveMQConfigBean implements Serializable {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;
    @Value("${spring.activemq.user}")
    private String user;
    @Value("${spring.activemq.password}")
    private String password;


    /**
     * 创建连接工厂
     */
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        activeMQConnectionFactory.setUserName(user);
        activeMQConnectionFactory.setPassword(password);
        return activeMQConnectionFactory;
    }


    @Bean
    public DefaultJmsListenerContainerFactory defaultMessageListenerContainer() {
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory());
        defaultJmsListenerContainerFactory.setSubscriptionDurable(true);
        defaultJmsListenerContainerFactory.setClientId("我是持久化订阅者一号");
        return defaultJmsListenerContainerFactory;
    }


}
