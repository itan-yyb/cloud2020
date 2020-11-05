package com.itan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/2
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashBoard9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashBoard9001.class,args);
    }
}
