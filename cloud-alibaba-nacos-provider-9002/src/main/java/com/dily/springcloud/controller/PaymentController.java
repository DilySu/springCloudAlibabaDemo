package com.dily.springcloud.controller;

import com.dily.springcloud.entities.Payment;
import com.dily.springcloud.reponse.BaseResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Date: 2022-11-22 星期二
 * Time: 15:31
 * Author: Dily_Su
 * Remark: 服务提供者测试接口
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/nacos/{id}")
    public String get(@PathVariable("id") Integer id) {
        return "nacos registry, serverPort:" + port + "\t" + id;
    }

    private static HashMap<Integer, Payment> paymentMap = new HashMap<>();
    static{
        paymentMap.put(1,new Payment(1L,"one"));
        paymentMap.put(2,new Payment(2L,"two"));
        paymentMap.put(3,new Payment(3L,"three"));
    }

    @GetMapping("/get/{id}")
    public BaseResponse getById(@PathVariable Integer id) {
        return new BaseResponse<>(200, id + '\t' +"from "+ '\t'  + port, paymentMap.get(id));
    }
}
