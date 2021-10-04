package com.itan.controller;

import com.itan.common.CommonResult;
import com.itan.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/11
 */
@Slf4j
@RestController
@RequestMapping("nacos1")
public class Payment9002Controller {
    @Value("${server.port}")
    private String port;

    @GetMapping(value = "getOne/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        log.info("nacos入参：{}",id);
        String result = "nacos port: "+ port + "\t id：" + id;
        log.info("nacos出参：{}",result);
        return result;
    }

    @GetMapping("getUser")
    public CommonResult getUser(){
        User user = new User();
        user.setName("123456");
        user.setCreateTime(LocalDateTime.now());
        CommonResult result = CommonResult.success(user);
        return result;
    }
}
