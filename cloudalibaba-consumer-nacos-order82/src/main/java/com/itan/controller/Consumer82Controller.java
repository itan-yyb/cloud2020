package com.itan.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itan.common.CommonResult;
import com.itan.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;


/**
 * @Author: yeyanbin
 * @Date: 2020/11/12
 */
@RestController
@RequestMapping("consumer")
public class Consumer82Controller {
    @Resource
    private RestTemplate restTemplate;

    @Value("${url.nacos-user-service}")
    private String URL;

    @GetMapping("/fallback/{id}")
//    @SentinelResource(value = "fallback") //没有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")
    public CommonResult fallback(@PathVariable Integer id) {
        CommonResult result = restTemplate.getForObject(URL + "/payment/" + id, CommonResult.class,id);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    /**
     * fallback是针对运行时异常的兜底方法
     */
    public CommonResult handlerFallback(@PathVariable  Integer id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult("444","兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }

    /**
     * blockHandler是针对sentinel配置违规的兜底方法
     */
    public CommonResult blockHandler(@PathVariable  Integer id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult("445","blockHandler-sentinel限流,无此流水: blockException  " + blockException.getMessage(),payment);
    }
}
