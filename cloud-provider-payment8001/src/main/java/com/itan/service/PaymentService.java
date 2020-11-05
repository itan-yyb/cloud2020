package com.itan.service;

import com.itan.entity.Payment;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/24 13:07
 */
public interface PaymentService {
    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    Payment getOne(Integer id);
}
