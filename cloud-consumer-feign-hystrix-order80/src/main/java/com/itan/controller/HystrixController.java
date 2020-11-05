package com.itan.controller;

import com.alibaba.fastjson.JSON;
import com.itan.entity.Payment;
import com.itan.feign.ProviderFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/1 20:55
 */
@Slf4j
@RestController
@RequestMapping("hystrix")
//@DefaultProperties(defaultFallback = "global")
public class HystrixController {
    @Resource
    private ProviderFeignClient providerFeignClient;

    @PostMapping("ok")
    @HystrixCommand
    public String getOne(@RequestBody Payment payment){
        log.info("入参：" + JSON.toJSONString(payment));
        String result = providerFeignClient.ok(payment);
        log.info("出参：" + JSON.toJSONString(result));
        return result;
    }

    @PostMapping("timeout")
//    @HystrixCommand(fallbackMethod = "timeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")  //3秒钟以内就是正常的业务逻辑
//    })
//    @HystrixCommand
    public String timeout(@RequestBody Payment payment){
        log.info("入参：" + JSON.toJSONString(payment));
        String result = providerFeignClient.timeout(payment);
        log.info("出参：" + JSON.toJSONString(result));
        return result;
    }

    //兜底方法
    public String timeOutFallbackMethod(@RequestBody Payment payment){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    //全局兜底方法
    public String global(){
        return "服务提供者系统繁忙或已经宕机，请稍后重试";
    }
}
