package com.itan.service.impl;

import com.itan.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.micrometer.core.instrument.util.TimeUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/1 19:18
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentService_OK,id:" + id;
    }

    /**
     * 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "timeOutHandler",commandProperties = {
            //3s内就是正常的业务
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String timeOut(Integer id) {
        //模拟超时、
        int age = 10/0;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "paymentService_timeOut,id:" + id;
    }

    @Override
    public String timeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "系统繁忙，请稍后再试";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "breaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),//失败率达到多少后跳闸
    })
    @Override
    public String breaker(Integer id){
        if (id < 0){
            throw new RuntimeException("id不能负数");
        }
        String serialNumber = UUID.randomUUID().toString();
        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }

    @Override
    public String breaker_fallback(Integer id){
        return "id不能负数，请稍候再试，id：" +id;
    }
}
