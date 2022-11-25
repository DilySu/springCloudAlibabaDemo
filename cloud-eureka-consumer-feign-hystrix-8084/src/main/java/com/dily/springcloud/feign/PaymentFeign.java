package com.dily.springcloud.feign;

import com.dily.springcloud.service.PaymentFallbackService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Date: 2022-11-03 星期四
 * Time: 15:29
 * Author: Dily_Su
 * Remark: feign
 */
@Component
@FeignClient(value = "cloud-hystrix-payment", fallback = PaymentFallbackService.class)
public interface PaymentFeign {

    @GetMapping("/payment/ok/{id}")
    String getOK(@PathVariable("id") Integer id);

    /**
     * 模拟被调服务响应时间需要3s
     */
    @GetMapping("/payment/timeout/{id}")
    String getTimeOut(@PathVariable("id") Integer id);

    @GetMapping("/payment/circuitBreak/{id}")
    String paymentCircuitBreak(@PathVariable("id") Integer id);
}
