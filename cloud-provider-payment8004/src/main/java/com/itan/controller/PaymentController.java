package com.itan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/29
 */
@Slf4j
@RestController
@RequestMapping("payment8004")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("consul")
    public String get(){
        return "springcloud with consul：" + port;
    }
}
