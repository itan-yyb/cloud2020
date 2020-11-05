package com.itan.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yeyanbin
 * @Date: 2020/10/30
 */
@Configuration
public class ConfigBean {
    @Bean
    public IRule RandomRule(){
        return new RandomRule();
    }
}
