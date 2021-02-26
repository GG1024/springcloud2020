package com.lucky.sz.controller;

import com.lucky.sz.common.CommonResult;
import com.lucky.sz.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-25 15:29
 **/
@Slf4j
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功!");
    }


}
