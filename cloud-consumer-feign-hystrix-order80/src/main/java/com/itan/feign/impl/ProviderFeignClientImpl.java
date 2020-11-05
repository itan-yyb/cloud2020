package com.itan.feign.impl;

import com.itan.entity.Payment;
import com.itan.feign.ProviderFeignClient;
import org.springframework.stereotype.Component;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/2
 */
@Component
public class ProviderFeignClientImpl implements ProviderFeignClient {
    @Override
    public String ok(Payment payment) {
        return "ok 方法故障";
    }

    @Override
    public String timeout(Payment payment) {
        return "timeout 方法故障";
    }
}
