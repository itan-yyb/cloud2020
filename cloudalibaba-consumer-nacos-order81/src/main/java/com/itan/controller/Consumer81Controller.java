package com.itan.controller;

import com.alibaba.fastjson.JSON;
import com.itan.common.CommonResult;
import com.itan.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;
import java.util.Map;


/**
 * @Author: yeyanbin
 * @Date: 2020/11/12
 */
@RestController
@RequestMapping("consumer")
public class Consumer81Controller {
    @Resource
    private RestTemplate restTemplate;

    @Value("${url.nacos-user-service}")
    private String URL;

    @GetMapping(value = "nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(URL + "/nacos1/getOne/" + id,String.class);
    }

    @GetMapping("getUser")
    public void getUser(){
        CommonResult result = restTemplate.getForObject(URL + "/nacos1/getUser", CommonResult.class);
        Map data = (Map) result.getData();
        User user = JSON.parseObject(JSON.toJSONString(data), User.class);
        System.out.println(user);
    }
}
