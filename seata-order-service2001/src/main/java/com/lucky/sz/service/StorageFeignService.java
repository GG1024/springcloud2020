package com.lucky.sz.service;

import com.lucky.sz.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @FileName: StorageFeignService.java
 * @description:
 * @author: OuYangXiaoGuang
 * @Date: 2021-02-25 15:05
 **/
@FeignClient(value = "seata-storage-service")
public interface StorageFeignService {

    /**
     * 减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
