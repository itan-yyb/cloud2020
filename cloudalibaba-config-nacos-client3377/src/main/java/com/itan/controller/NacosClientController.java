package com.itan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/12
 */
@RefreshScope
@RestController
@RequestMapping("config")
public class NacosClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("info")
    public String getConfigInfo() {
        return configInfo;
    }
}
