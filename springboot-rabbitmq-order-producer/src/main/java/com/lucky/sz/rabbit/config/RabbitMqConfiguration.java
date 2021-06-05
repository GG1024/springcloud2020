package com.lucky.sz.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * @FileName: RabbitMqConfiguration.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-06-05
 **/
@Configuration
public class RabbitMqConfiguration implements Serializable {

    //1.声明注册fanout模式的交换机
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout_order_exchange", true, false);
    }

    //2.声明队列 sms.fanout.queue email.fanout.queue duanxin.fanout.queue
    @Bean
    public Queue smsQueue() {
        return new Queue("sms.fanout.queue", true);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue("email.fanout.queue", true);
    }

    @Bean
    public Queue duanxinQueue() {
        return new Queue("duanxin.fanout.queue", true);
    }


    //3.完成交换机与队列的绑定关系
    @Bean
    public Binding bindingSms() {
        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingEmail() {
        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingDuanxin() {
        return BindingBuilder.bind(duanxinQueue()).to(fanoutExchange());
    }

}
