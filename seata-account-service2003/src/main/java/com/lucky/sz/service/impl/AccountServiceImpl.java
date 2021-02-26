package com.lucky.sz.service.impl;

import com.lucky.sz.dao.AccountDao;
import com.lucky.sz.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @FileName: AccountServiceImpl.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-25
 **/
@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("----> account-service中扣减用户余额开始");
        accountDao.decrease(userId, money);
        LOGGER.info("----> account-service中扣减用户余额开始");
    }

}
