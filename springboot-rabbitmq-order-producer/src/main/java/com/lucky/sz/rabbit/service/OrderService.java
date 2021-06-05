package com.lucky.sz.rabbit.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.UUID;

/**
 * @FileName: OrderService.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-06-05
 **/
@Service
public class OrderService implements Serializable {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 模拟下单
     *
     * @param userId
     * @param productId
     * @param num
     */
    public void makeOrder(String userId, String productId, int num) {

        //1:根据商品id查询库存是否充足
        //2:保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功：" + orderId);

        //3.通过MQ来完成消息的分发
        String exchangeName = "fanout_order_exchange";
        String routingKey = "";
        /**
         * @param1 交换机
         * @param2 路由Key/queue
         * @param3 消息内容
         */
        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderId);
    }


}
