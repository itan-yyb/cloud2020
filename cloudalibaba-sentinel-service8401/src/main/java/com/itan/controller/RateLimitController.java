package com.itan.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itan.common.CommonResult;
import com.itan.entity.Payment;
import com.itan.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/22 16:16
 */
@Slf4j
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult("200","按资源名称限流测试OK",new Payment(2020,"serial001"));
    }
    public CommonResult handleException(BlockException exception) {
        return new CommonResult("444",exception.getClass().getCanonicalName() + "：服务不可用");
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    //当QPS超过阈值，就会找到blockHandlerClass对应的类中blockHandler对应的方法名进行兜底处理
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult("200","按客戶自定义",new Payment(200,"serial003"));
    }
}
