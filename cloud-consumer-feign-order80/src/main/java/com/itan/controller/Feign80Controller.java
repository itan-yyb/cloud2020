package com.itan.controller;

import com.alibaba.fastjson.JSON;
import com.itan.common.CommonResult;
import com.itan.entity.Payment;
import com.itan.feign.ProviderFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @Author: yeyanbin
 * @Date: 2020/10/30
 */
@Slf4j
@RestController
@RequestMapping("feign")
public class Feign80Controller {
    @Resource
    private ProviderFeignClient providerFeignClient;

    @PostMapping("getOne")
    public CommonResult getOne(@RequestBody Payment payment){
        log.info("入参：" + JSON.toJSONString(payment));
        CommonResult result = providerFeignClient.getOne(payment);
        log.info("出参：" + JSON.toJSONString(result));
        return result;
    }

    @PostMapping("timeout")
    public CommonResult timeout(){
        //openFeign-ribbon，客户端一般默认等待1秒钟
        CommonResult result = CommonResult.success(providerFeignClient.timeout());
        return result;
    }
}
