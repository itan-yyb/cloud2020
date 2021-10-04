package com.itan.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/26
 */
@Repository
public interface StorageMapper {
    /**
     * 扣减库存信息
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
