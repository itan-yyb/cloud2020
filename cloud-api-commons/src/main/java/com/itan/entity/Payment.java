package com.itan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/23 17:57
 */
@Data
@AllArgsConstructor
public class Payment implements Serializable {
    private Integer id;
    private String serial;
}
