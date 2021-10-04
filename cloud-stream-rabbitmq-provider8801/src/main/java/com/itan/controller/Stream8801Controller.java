package com.itan.controller;

import com.itan.service.Stream8801Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/9
 */
@RestController
@RequestMapping("stream")
public class Stream8801Controller {
    @Resource
    private Stream8801Service stream8801Service;

    @GetMapping("sendMessage")
    public String sendMessage(){
        return stream8801Service.send();
    }
}
