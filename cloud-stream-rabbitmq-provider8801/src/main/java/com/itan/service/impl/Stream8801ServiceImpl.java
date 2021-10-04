package com.itan.service.impl;

import com.itan.service.Stream8801Service;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.UUID;
/**
 * @Author: yeyanbin
 * @Date: 2020/11/9
 */
@Service
@EnableBinding(Source.class)//定义消息的推送管道
public class Stream8801ServiceImpl implements Stream8801Service {
    @Resource
    private MessageChannel output; //消息发送管道名称要与配置中的一致

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return null;
    }
}
