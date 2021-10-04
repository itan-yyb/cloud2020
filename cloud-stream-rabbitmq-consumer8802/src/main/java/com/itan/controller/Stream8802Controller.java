package com.itan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/9
 */
@Component
@EnableBinding(Sink.class)
public class Stream8802Controller {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message) {
        System.out.println("消费者1号，接收：" + message.getPayload() + "\t port:" + port);
    }
}
