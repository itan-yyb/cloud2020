package com.itan.controller;

import com.alibaba.fastjson.JSON;
import com.itan.entity.Payment;
import com.itan.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/24 13:14
 */
@Slf4j
@RestController
@RequestMapping("hystrix")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("ok")
    public String getOne(@RequestBody Payment payment){
        log.info("入参：" + JSON.toJSONString(payment));
        String result = paymentService.ok(payment.getId());
        log.info("出参：" + JSON.toJSONString(result));
        return result;
    }

    @PostMapping("timeout")
    public String timeout(@RequestBody Payment payment){
        log.info("入参：" + JSON.toJSONString(payment));
        String result = paymentService.timeOut(payment.getId());
        log.info("出参：" + JSON.toJSONString(result));
        return result;
    }

    @PostMapping("breaker")
    public String breaker(@RequestBody Payment payment){
        log.info("入参：" + JSON.toJSONString(payment));
        String result = paymentService.breaker(payment.getId());
        log.info("出参：" + JSON.toJSONString(result));
        return result;
    }
}
