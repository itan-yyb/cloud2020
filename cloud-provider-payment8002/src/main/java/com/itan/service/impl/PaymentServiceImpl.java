package com.itan.service.impl;

import com.itan.dao.PaymentMapper;
import com.itan.entity.Payment;
import com.itan.service.PaymentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/24 13:07
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public Payment getOne(Integer id) {
        return paymentMapper.getOne(id);
    }
}
