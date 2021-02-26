package com.lucky.sz.service;

import java.math.BigDecimal;

/**
 * @FileName: AccountService.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-25 15:55
 **/
public interface AccountService {
    void decrease(Long userId, BigDecimal money);

}
