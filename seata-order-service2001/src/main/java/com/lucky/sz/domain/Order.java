package com.lucky.sz.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @FileName: Order.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    private Integer status;


}
