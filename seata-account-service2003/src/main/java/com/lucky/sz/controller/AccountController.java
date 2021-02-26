package com.lucky.sz.controller;

import com.lucky.sz.common.CommonResult;
import com.lucky.sz.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-26 09:35
 **/
@Slf4j
@RestController
public class AccountController {
    @Resource
    AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功！");
    }


}
