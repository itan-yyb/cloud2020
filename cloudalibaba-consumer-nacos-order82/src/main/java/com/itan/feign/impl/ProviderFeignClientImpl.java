package com.itan.feign.impl;

import com.itan.common.CommonResult;
import com.itan.entity.Payment;
import com.itan.feign.ProviderFeignClient;
import org.springframework.stereotype.Service;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/23
 */
@Service
public class ProviderFeignClientImpl implements ProviderFeignClient {
    @Override
    public CommonResult payment(Integer id) {
        return new CommonResult("44444","服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
