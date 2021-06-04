package com.lucky.sz.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @FileName: Stock.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-03-01
 **/
@Data
public class Stock implements Serializable {


    private Integer Id;


    private String name;

    private Integer count;

    private Integer sale;

    private int version;

}
