package com.lucky.sz.dao;

import com.lucky.sz.domain.Stock;
import org.apache.ibatis.annotations.Mapper;

/**
 * @FileName: StockDAO.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-03-01 17:11
 **/
@Mapper
public interface StockDAO {
    //校验库存
    Stock checkStock(Integer id);

    //扣除库存
    void updateSale(Stock stock);

}
