package com.dily.springcloud.controller;

import com.dily.springcloud.feign.PaymentFeign;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Date: 2022-11-04 星期五
 * Time: 15:55
 * Author: Dily_Su
 * Remark:
 */
@RestController
@RequestMapping("/order")
@DefaultProperties(defaultFallback = "globalTimeOutFallback")  // 单独类使用默认降级方案
public class OrderController {

    @Resource
    private PaymentFeign paymentFeign;

    // +++++++++++++++ 服务降级

    @GetMapping("/ok/{id}")
    public String getOK(@PathVariable("id") Integer id) {
        return paymentFeign.getOK(id);
    }

    /**
     * 模拟被调服务响应时间需要3s
     */
    @GetMapping("/timeout/{id}")
    @HystrixCommand
    // 单独方法使用特定的降级方案
//    @HystrixCommand(fallbackMethod = "getTimeOutFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    public String getTimeOut(@PathVariable("id") Integer id) {
        return paymentFeign.getTimeOut(id);
    }

    public String getTimeOutFallback(@PathVariable("id") Integer id) {
        return "我是消费者，支付系统繁忙，请10s后重试！";
    }

    public String globalTimeOutFallback() {
        return "系统繁忙，请10s后重试！";
    }


    // +++++++++++++++ 服务熔断
    @GetMapping("/circuitBreak/{id}")
    public String paymentCircuitBreak(@PathVariable("id") Integer id) {
        return paymentFeign.paymentCircuitBreak(id);
    }

}
