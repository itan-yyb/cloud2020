package com.itan.service.impl;

import com.itan.dao.OrderMapper;
import com.itan.entity.Order;
import com.itan.service.AccountService;
import com.itan.service.OrderService;
import com.itan.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/26
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order){
        log.info("----->开始新建订单");
        //新建订单
        orderMapper.create(order);
        //扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");
        //扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");
        //修改订单状态，从0到1代表已经完成
        log.info("----->修改订单状态开始");
        orderMapper.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");
        log.info("----->下订单结束了");
    }
}
