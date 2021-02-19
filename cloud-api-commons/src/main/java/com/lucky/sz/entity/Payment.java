package com.lucky.sz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @FileName: Payment.java
 * @description:
 * @author: 欧阳小广
 * @Date: 2021-02-19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
