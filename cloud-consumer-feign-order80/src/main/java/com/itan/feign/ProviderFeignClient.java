package com.itan.feign;

import com.itan.common.CommonResult;
import com.itan.entity.Payment;
import feign.Request;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: yeyanbin
 * @Date: 2020/10/31 6:30
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",configuration = {ProviderFeignClient.ProviderFeignClientConfigure.class})
public interface ProviderFeignClient {
    @PostMapping("payment/getOne")
    CommonResult getOne(Payment payment);

    @PostMapping("payment/timeout")
    String timeout();

    class ProviderFeignClientConfigure{
        //设置超时时间
        @Bean
        Request.Options options(){
            return new Request.Options(30000,60000);
        }
    }
}
