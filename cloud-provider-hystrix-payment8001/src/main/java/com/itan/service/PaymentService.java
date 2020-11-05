package com.itan.service;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/1 19:16
 */
public interface PaymentService {
    String ok(Integer id);

    String timeOut(Integer id);

    String timeOutHandler(Integer id);

    String breaker(Integer id);

    String breaker_fallback(Integer id);
}
