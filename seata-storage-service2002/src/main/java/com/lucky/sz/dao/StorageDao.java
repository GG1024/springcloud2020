package com.lucky.sz.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @FileName: OrderDao.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-25 15:02
 **/
@Mapper
public interface StorageDao {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
