package com.itan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/28
 */
@Slf4j
@RestController
@RequestMapping("payment8003")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("zk")
    public String payment(){
        return "SpringCloud with zookeeper：" + port + "\t" + UUID.randomUUID().toString();
    }
}
