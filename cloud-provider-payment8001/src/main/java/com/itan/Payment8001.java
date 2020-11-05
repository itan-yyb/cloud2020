package com.itan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/23 15:40
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.itan.dao"})
// 本服务启动后会自动注册进 eureka 服务中
@EnableEurekaClient
@EnableDiscoveryClient//服务发现
public class Payment8001 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001.class,args);
    }
}
