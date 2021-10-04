package com.itan.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/26
 */
@Repository
public interface AccountMapper {
    /**
     * 扣减账户余额
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
