package com.itan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/1 20:29
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class Hystrix80 {
    public static void main(String[] args) {
        SpringApplication.run(Hystrix80.class,args);
    }
}
