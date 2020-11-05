package com.itan.service;

import com.itan.common.CommonResult;
import com.itan.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: yeyanbin
 * @Date: 2020/10/30
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignProvderService {
    @PostMapping("payment/getOne")
    CommonResult getOne(Payment payment);
}
