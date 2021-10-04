package com.itan.feign;

import com.itan.common.CommonResult;
import com.itan.entity.Payment;
import com.itan.feign.impl.ProviderFeignClientImpl;
import feign.Request;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/23
 */
@FeignClient(value = "nacos-payment-provider",
        configuration = {ProviderFeignClient.ProviderFeignClientConfigure.class},
        fallback = ProviderFeignClientImpl.class)
public interface ProviderFeignClient {
    @GetMapping(value = "/payment/{id}")
    CommonResult payment(@PathVariable("id") Integer id);

    class ProviderFeignClientConfigure{
        //设置超时时间
        @Bean
        Request.Options options(){
            return new Request.Options(30000,60000);
        }
    }
}