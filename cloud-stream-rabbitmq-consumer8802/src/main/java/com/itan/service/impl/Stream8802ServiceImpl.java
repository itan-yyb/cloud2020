package com.itan.service.impl;

import com.itan.service.Stream8802Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/9
 */
@Service
@EnableBinding(Sink.class)
public class Stream8802ServiceImpl implements Stream8802Service {
    @Value("${server.port}")
    private String serverPort;

    @Override
    @StreamListener(Sink.INPUT)
    public String receive(Message<String> message) {
        String receive = "消费者1号，接受："+message.getPayload()+"\t port:"+serverPort;
        return receive;
    }
}
