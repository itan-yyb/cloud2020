package com.itan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/12
 */
@SpringBootApplication
@EnableDiscoveryClient//服务发现
public class NacosClient3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosClient3377.class,args);
    }
}