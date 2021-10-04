package com.itan.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/16
 */
@Slf4j
@RestController
@RequestMapping("sentinel")
public class Sentinel8401Controller {
    @GetMapping("getA")
    public String testA(){
        return "--------testA";
    }

    @GetMapping("getB")
    public String testB(){
        return "--------testB";
    }

    @GetMapping("getC")
    public String testC(){
        log.info("testC 测试异常比例");
        int i = 10 / 0;
        return "------testC";
    }

    @GetMapping("getD")
    public String testD(){
        log.info("testD 测试异常数");
        int i = 10 / 0;
        return "--------testD";
    }


    @GetMapping("getE")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testE(@RequestParam(value = "p1",required = false) String p1,
                        @RequestParam(value = "p2",required = false) String p2) {
        int i = 10 / 0;
        return "------testHotKey";
    }

    //兜底方法
    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }
}