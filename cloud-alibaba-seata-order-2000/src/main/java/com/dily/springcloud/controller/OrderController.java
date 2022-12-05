package com.dily.springcloud.controller;

import com.dily.springcloud.entity.Order;
import com.dily.springcloud.reponse.BaseResponse;
import com.dily.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Date: 2022-11-30 星期三
 * Time: 15:30
 * Author: Dily_Su
 * Remark:
 */
@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("create")
    public BaseResponse create(Order order) {
        orderService.create(order);
        return new BaseResponse<>(200, "订单创建成功！");
    }

    @PostMapping("/update")
    public BaseResponse update(@RequestBody Order order) {
        orderService.updateOrder(order.getUserId(), order.getStatus());
        return new BaseResponse<>(200,"修改成功");
    }
}
