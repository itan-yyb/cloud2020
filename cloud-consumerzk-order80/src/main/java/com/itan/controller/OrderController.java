package com.itan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/29
 */
@Slf4j
@RestController
@RequestMapping("consumer")
public class OrderController {
    private static final String PAYMENT_URL = "http://cloud-provider-payment/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("get")
    public String get(){
        String result = restTemplate.getForObject(PAYMENT_URL + "payment8003/zk", String.class);
        return result;
    }
}
