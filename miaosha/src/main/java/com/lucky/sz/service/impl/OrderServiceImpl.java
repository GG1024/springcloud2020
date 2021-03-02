package com.lucky.sz.service.impl;

import com.lucky.sz.dao.OrderDAO;
import com.lucky.sz.dao.StockDAO;
import com.lucky.sz.domain.Stock;
import com.lucky.sz.domain.StockOrder;
import com.lucky.sz.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * @FileName: OrderServiceImpl.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-01
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private StockDAO stockDAO;

    @Resource
    private OrderDAO orderDAO;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public  Integer createOrder(Integer id) {
        //校验库存
        Stock stock = checkStock(id);
        //扣库存
        updateSale(stock);
        //创建订单
        return createOrder(stock);

    }


    private Stock checkStock(Integer id) {
        Stock stock = stockDAO.checkStock(id);
        if (stock.getSale().equals(stock.getCount())) {
            throw new RuntimeException("库存不足");
        }
        return stock;
    }


    private void updateSale(Stock stock) {

        stockDAO.updateSale(stock);

    }

    private Integer createOrder(Stock stock) {
        StockOrder stockOrder = new StockOrder();
        stockOrder.setSid(stock.getId());
        stockOrder.setCreateTime(new Date());
        stockOrder.setName(stock.getName());
        orderDAO.createOrder(stockOrder);
        return stockOrder.getId();
    }


}



