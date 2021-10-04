package com.itan.controller;

import com.alibaba.fastjson.JSON;
import com.itan.common.CommonResult;
import com.itan.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/24 15:03
 */
@Slf4j
@RestController
@RequestMapping("consumer")
public class OrderController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("getOne")
    public CommonResult getOne(@RequestBody Payment payment){
        log.info("入参：" + JSON.toJSONString(payment));
        CommonResult result = restTemplate.postForObject(PAYMENT_URL + "payment/getOne", payment, CommonResult.class);
        log.info("出参：" + JSON.toJSONString(result));
        return result;
    }

    @PostMapping("discovery")
    public Object discovery(){
        return restTemplate.getForObject(PAYMENT_URL + "discovery/serviceList", Object.class);
    }

    @GetMapping("zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin/", String.class);
        return result;
    }
}
