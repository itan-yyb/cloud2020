package com.itan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: yeyanbin
 * @Date: 2020/10/30
 */
@SpringBootApplication
@EnableFeignClients
public class Feign80 {
    public static void main(String[] args) {
        SpringApplication.run(Feign80.class,args);
    }
}
