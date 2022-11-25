package com.dily.springcloud.controller;

import com.dily.springcloud.feign.PaymentFeign;
import com.dily.springcloud.reponse.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 2022-11-03 星期四
 * Time: 15:29
 * Author: Dily_Su
 * Remark:
 */
@RestController
@RequestMapping("/feignOrder")
public class OrderController {
    @Autowired
    private PaymentFeign paymentFeign;

    @GetMapping("/get/{id}")
    public BaseResponse<?> payment (@PathVariable("id") Long id){
        return paymentFeign.getById(id);
    }

    @GetMapping("/timeout/lb")
    public String getTimeOutLB (){
        return paymentFeign.getTimeOutLB();
    }
}
