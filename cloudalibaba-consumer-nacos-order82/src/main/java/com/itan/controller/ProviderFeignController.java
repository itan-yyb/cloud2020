package com.itan.controller;

import com.itan.common.CommonResult;
import com.itan.entity.Payment;
import com.itan.feign.ProviderFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/23
 */
@RestController
public class ProviderFeignController {
    @Resource
    private ProviderFeignClient providerFeignClient;

    @GetMapping(value = "/feign/payment/{id}")
    public CommonResult payment(@PathVariable("id") Integer id) {
        return providerFeignClient.payment(id);
    }
}
