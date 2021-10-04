package com.itan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/8 15:55
 */
@RefreshScope
@RestController
@RequestMapping("config")
public class ConfigClientController3366 {
    @Value("${de.name}")
    private String name;

    @Value("${server.port}")
    private String port;

    @GetMapping("getOne")
    public String getOne(){
        return "端口号：" + port + "配置信息:" + name;
    }
}
