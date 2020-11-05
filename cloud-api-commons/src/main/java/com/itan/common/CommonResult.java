package com.itan.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: yeyanbin
 * @Date: 2020/9/24 10:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    /**状态码**/
    private String code;
    /**返回消息**/
    private String message;
    /**返回数据**/
    private T data;
    /**返回成功方法**/
    public static CommonResult success(Object data) {
        return new CommonResult("200","success",data);
    }
}
