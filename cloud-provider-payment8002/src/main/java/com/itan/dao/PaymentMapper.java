package com.itan.dao;

import com.itan.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/24 10:57
 */
@Repository
public interface PaymentMapper {
    /**
     * 根据id获取payment信息
     * @param id
     * @return
     */
    Payment getOne(@Param("id") Integer id);
}
