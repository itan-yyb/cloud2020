package com.itan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/25 11:04
 */
@SpringBootApplication
// EurekaServer 服务器端启动类，接受其他微服务注册进来
@EnableEurekaServer
public class Eureka7001 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7001.class,args);
    }
}
