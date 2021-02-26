package com.lucky.sz.service.impl;

import com.lucky.sz.dao.OrderDao;
import com.lucky.sz.domain.Order;
import com.lucky.sz.service.AccountFeignService;
import com.lucky.sz.service.OrderService;
import com.lucky.sz.service.StorageFeignService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @FileName: OrderServiceImpl.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-25 15:07
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private AccountFeignService accountFeignService;

    @Resource
    private StorageFeignService storageFeignService;
    @Resource
    private OrderDao orderDao;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     *
     * 下订单->减库存->减余额->改状态
     *
     *GlobalTransactional seata开启分布式事务,异常时回滚,name保证唯一即可
     */


    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {

        // 1 新建订单
        log.info("----->开始新建订单");
        orderDao.create(order);

        // 2 扣减库存
        log.info("----->订单微服务开始调用库存,做扣减Count");
        storageFeignService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存,做扣减End");

        // 3 扣减账户
        log.info("----->订单微服务开始调用账户,做扣减Money");
        accountFeignService.decrease(order.getUserId(), order.getMoney());
        log.info("----->订单微服务开始调用账户,做扣减End");


        // 4 修改订单状态,从0到1,1代表已完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);

        log.info("----->下订单结束了,O(∩_∩)O哈哈~");

    }
}
