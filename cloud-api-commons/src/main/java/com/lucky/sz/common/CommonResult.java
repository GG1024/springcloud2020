package com.lucky.sz.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @FileName: CommonResult.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    // 404 not found
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }


}
