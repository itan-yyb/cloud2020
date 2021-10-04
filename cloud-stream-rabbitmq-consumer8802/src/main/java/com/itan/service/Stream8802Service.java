package com.itan.service;

import org.springframework.messaging.Message;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/9
 */
public interface Stream8802Service {
    /**
     * 接收消息
     */
    String receive(Message<String> message);
}
