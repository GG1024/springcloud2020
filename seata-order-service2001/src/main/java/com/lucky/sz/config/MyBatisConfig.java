package com.lucky.sz.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @FileName: MyBatisConfig.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-25
 **/
@Configuration
@MapperScan({"com.lucky.sz.dao"})
public class MyBatisConfig {
}
