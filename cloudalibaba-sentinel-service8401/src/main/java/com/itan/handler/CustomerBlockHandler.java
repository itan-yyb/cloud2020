package com.itan.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itan.common.CommonResult;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/22 18:51
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult("20000","自定义的限流处理类----CustomerBlockHandler----1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult("20000","自定义的限流处理类----CustomerBlockHandler----2");
    }
}
