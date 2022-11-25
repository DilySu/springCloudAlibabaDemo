package com.dily.springcloud.controller;

import com.dily.springcloud.feign.PaymentFeign;
import com.dily.springcloud.reponse.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 2022-11-24 星期四
 * Time: 16:47
 * Author: Dily_Su
 * Remark: 服务消费者
 * openfeign + sentinel
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private PaymentFeign paymentFeign;

    @GetMapping("/get/{id}")
    public BaseResponse getId(@PathVariable Integer id) {
        return paymentFeign.getById(id);
    }
}
