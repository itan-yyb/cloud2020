package com.itan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/22 21:16
 */
@EnableDiscoveryClient //用于服务发现
@SpringBootApplication
@EnableFeignClients
public class Consumer82 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer82.class,args);
    }
}
