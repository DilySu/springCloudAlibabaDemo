package com.dily.springcloud.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dily.springcloud.entity.Order;
import com.dily.springcloud.feign.AccountFeign;
import com.dily.springcloud.feign.StorageFeign;
import com.dily.springcloud.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Date: 2022-11-30 星期三
 * Time: 14:49
 * Author: Dily_Su
 * Remark:
 */
@Service
@Slf4j
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Resource
    private StorageFeign storageFeign;
    @Resource
    private AccountFeign accountFeign;

    /**
     * 新建订单
     *  创建订单 => 库存扣减 => 账户扣钱
     * @param order 订单
     */
    public void create(Order order) {
        log.info("---------------开始创建订单");
        this.save(order);

        // 库存扣减
        log.info("---------------订单微服务开始调用库存，做扣减");
        storageFeign.decrease(order.getProductId(), order.getCount());
        log.info("---------------订单微服务开始调用库存，做扣减end");

        // 账户扣钱
        log.info("---------------订单微服务开始调用账户，做扣钱");
        accountFeign.decrease(order.getUserId(),order.getMoney());
        log.info("---------------订单微服务开始调用账户，做扣钱end");

        // 修改订单状态 从 0 => 1
        log.info("---------------修改订单状态，开始");
        updateOrder(order.getUserId(),0);
        log.info("---------------修改订单状态，结束");

        log.info("---------------下单成功！");
    }

    /**
     * 修改订单：状态由 0 改为 1
     *
     * @param userId 用户ID
     * @param status 状态
     */
    public void updateOrder(Long userId, Integer status) {
        log.info("---------------开始更新订单");
        Order order = this.getOne(new QueryWrapper<Order>()
                .eq("user_id", userId)
                .eq("status",status)
        );

        this.update(new LambdaUpdateWrapper<Order>()
                .eq(Order::getId, order.getId())
                .set(Order::getStatus, 1)
        );
    }


}
