package com.itan.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/13
 */
@Data
public class User {
    private String name;

    private LocalDateTime createTime;
}
