package com.itan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/29
 */
@RestController
@RequestMapping("consumer")
public class OrderController {
    public static final String INVOME_URL = "http://consul-provider-payment/";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public String get(){
        String result = restTemplate.getForObject(INVOME_URL + "payment8004/consul",String.class);
        return result;
    }
}
