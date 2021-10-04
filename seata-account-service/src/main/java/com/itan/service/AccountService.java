package com.itan.service;

import org.springframework.web.bind.annotation.RequestParam;
import java.math.BigDecimal;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/26
 */
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId
     * @param money
     */
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
