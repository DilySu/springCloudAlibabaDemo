package com.dily.springcloud.controller;

import com.dily.springcloud.entities.Payment;
import com.dily.springcloud.reponse.BaseResponse;
import com.dily.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Date: 2022-10-27 星期四
 * Time: 14:49
 * Author: Dily_Su
 * Remark:
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired // 用于服务发现
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ok/{id}")
    public String getOK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("********************" + result);
        return result;
    }

    @GetMapping("/timeout/{id}")
    public String getTimeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("********************" + result);
        return result;
    }

    @GetMapping("/circuitBreak/{id}")
    public String paymentCircuitBreak(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreak(id);
        log.info("********************" + result);
        return result;
    }
}