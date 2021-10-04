package com.itan.controller;

import com.alibaba.fastjson.JSON;
import com.itan.common.CommonResult;
import com.itan.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/22 20:53
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Integer, Payment> hashMap = new HashMap<>();
    static{
        hashMap.put(1,new Payment(1,"28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2,new Payment(2,"bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3,new Payment(3,"6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Integer id){
        Payment payment = hashMap.get(id);
        CommonResult result = new CommonResult("200","from mysql,serverPort:  " + serverPort, payment);
        return result;
    }
}
