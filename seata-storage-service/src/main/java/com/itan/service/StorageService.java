package com.itan.service;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/26
 */
public interface StorageService {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
