package com.itan.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/12
 */
@Configuration
public class Consumer81Config {
    @Bean
    @LoadBalanced //负载均衡，轮询方式
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
