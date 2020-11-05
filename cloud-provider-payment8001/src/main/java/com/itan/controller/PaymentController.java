package com.itan.controller;

import com.alibaba.fastjson.JSON;
import com.itan.common.CommonResult;
import com.itan.entity.Payment;
import com.itan.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/24 13:14
 */
@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("getOne")
    public CommonResult getOne(@RequestBody Payment payment){
        log.info("入参：" + JSON.toJSONString(payment));
        Payment one = paymentService.getOne(payment.getId());
        Map<String,Object> map = new HashMap<>();
        map.put("entity",one);
        map.put("port",port);
        CommonResult result = CommonResult.success(map);
        log.info("出参：" + JSON.toJSONString(result));
        return result;
    }

    @PostMapping("timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return port;
    }

    public static void main(String[] args) {
        //获取时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        //2020-11-04T22:49:28.962+08:00[Asia/Shanghai]
    }
}
