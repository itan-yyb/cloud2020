package com.itan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/28
 */
@RequestMapping("discovery")
public class DiscoveryController {
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("list")
    public Object discovery(){
        return restTemplate.getForObject(PAYMENT_URL + "discovery/serviceList", Object.class);
    }
}
