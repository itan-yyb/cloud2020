package com.itan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment8003 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8003.class,args);
    }
}
