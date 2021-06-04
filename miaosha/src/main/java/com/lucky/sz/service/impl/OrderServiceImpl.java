package com.lucky.sz.service.impl;

import com.lucky.sz.dao.OrderDAO;
import com.lucky.sz.dao.StockDAO;
import com.lucky.sz.dao.UserDAO;
import com.lucky.sz.domain.Stock;
import com.lucky.sz.domain.StockOrder;
import com.lucky.sz.domain.User;
import com.lucky.sz.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private UserDAO userDAO;


    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer createOrder(Integer id) {
        if (!stringRedisTemplate.hasKey("kill" + id)) {
            throw new RuntimeException("秒杀超时,活动已经结束了~~~~~");
        }
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

        int updateRows = stockDAO.updateSale(stock);
        if (updateRows == 0) {
            throw new RuntimeException("抢购失败,请重试!");
        }

    }

    private Integer createOrder(Stock stock) {
        StockOrder stockOrder = new StockOrder();
        stockOrder.setSid(stock.getId());
        stockOrder.setCreateTime(new Date());
        stockOrder.setName(stock.getName());
        orderDAO.createOrder(stockOrder);
        return stockOrder.getId();
    }


    @Override
    public String getMd5(Integer id, Integer userid) {

        //检验用户合法性
        User user = userDAO.findById(userid);
        if (user == null) {
            throw new RuntimeException("该用户不存在");
        }
        //检验商品合法性
        Stock stock = stockDAO.checkStock(id);
        if (stock == null) {
            throw new RuntimeException("该商品不存在");
        }
        //生成hashKey
        String hashKey = "KEY_" + userid + "_" + id;
        //生成md5
        String key = DigestUtils.md5DigestAsHex((userid + id + "!Q*jS#").getBytes());
        stringRedisTemplate.opsForValue().set(hashKey, key, 3600, TimeUnit.SECONDS);
        return key;
    }


    @Override
    public Integer kill(Integer id, Integer userId, String md5) {
        //验证签名
        String hashKey =  "KEY_" + userId + "_" + id;
        String result = stringRedisTemplate.opsForValue().get(hashKey);

        if (result==null){
            throw  new RuntimeException("没有携带验证签名,请求不合法!!!");
        }
        if (!result.equals(md5)){
            throw new RuntimeException("当前请求数据不合法,请稍后重试");
        }

        //校验库存
        Stock stock = checkStock(id);
        //扣库存
        updateSale(stock);
        //创建订单
        return createOrder(stock);
    }
}



