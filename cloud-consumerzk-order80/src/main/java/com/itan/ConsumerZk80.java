package com.itan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerZk80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZk80.class,args);
    }
}
