package com.itan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/10
 */
@RestController
@RequestMapping("payment")
public class PaymentZipkinController {
    @GetMapping("zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，O(∩_∩)O哈哈~";
    }
}
