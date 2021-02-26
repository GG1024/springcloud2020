package com.lucky.sz.service;

import com.lucky.sz.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @FileName: AccountFeignService.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-25 15:05
 **/
@FeignClient(value = "seata-account-service")
public interface AccountFeignService {

    /**
     * 减余额
     *
     * @param userId
     * @param money
     * @return
     */
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
