package com.itan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/26
 */
@EnableFeignClients
@EnableDiscoveryClient//服务发现
//取消数据源的自动创建
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = {"com.itan.dao"})//扫描Mapper接口
public class AccountServer {
    public static void main(String[] args) {
        SpringApplication.run(AccountServer.class,args);
    }
}
