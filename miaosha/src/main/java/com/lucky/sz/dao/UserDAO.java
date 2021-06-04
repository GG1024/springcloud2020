package com.lucky.sz.dao;

import com.lucky.sz.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @FileName: UserDAO.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-03-02 14:41
 **/
@Mapper
public interface UserDAO {

    User findById(Integer userId);


}
