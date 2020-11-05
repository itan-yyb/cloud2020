package com.itan.controller;

import com.alibaba.fastjson.JSON;
import com.itan.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/28
 */
@RestController
@RequestMapping("discovery")
@Slf4j
public class DiscoveryController {
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("serviceList")
    public Object discovery(){
        //获取所有服务
        List<String> list = discoveryClient.getServices();
        log.info("所有的服务：" + JSON.toJSONString(list));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.stream().forEach(instance -> {
            log.info("服务id：" + instance.getServiceId() + "\t主机：" + instance.getHost() + "\t端口号：" + instance.getPort() + "\t地址：" + instance.getUri());
        });
        return this.discoveryClient;
    }
}
