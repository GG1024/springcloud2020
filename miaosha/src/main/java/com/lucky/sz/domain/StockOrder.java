package com.lucky.sz.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @FileName: StockOrder.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-01
 **/
@Data
public class StockOrder implements Serializable {


    private Integer Id;

    private Integer sid;

    private String name;

    private Date createTime;


}
