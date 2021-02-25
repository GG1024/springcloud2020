package com.lucky.sz.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lucky.sz.common.CommonResult;
import com.lucky.sz.entity.Payment;

import java.io.Serializable;

/**
 * @FileName: CustomerBlockHandler.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-25
 **/
public class CustomerBlockHandler implements Serializable {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "按照客户自定义的Glogal 全局异常处理 ---- 1", new Payment(2020L, "serial003"));
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "按照客户自定义的Glogal 全局异常处理 ---- 2", new Payment(2020L, "serial003"));
    }

}
