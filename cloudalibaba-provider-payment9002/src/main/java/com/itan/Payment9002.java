package com.itan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/12
 */
@EnableDiscoveryClient //用于服务发现
@SpringBootApplication
public class Payment9002 {
    public static void main(String[] args) {
        SpringApplication.run(Payment9002.class,args);
    }
}
