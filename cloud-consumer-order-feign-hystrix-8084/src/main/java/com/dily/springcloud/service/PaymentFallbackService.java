package com.dily.springcloud.service;

import com.dily.springcloud.feign.PaymentFeign;
import org.springframework.stereotype.Component;

/**
 * Date: 2022-11-08 星期二
 * Time: 10:58
 * Author: Dily_Su
 * Remark: PaymentFeign 的降级方案
 */
@Component
public class PaymentFallbackService implements PaymentFeign {
    @Override
    public String getOK(Integer id) {
        return "PaymentFallbackService fall back-paymentInfo_Ok!";
    }

    @Override
    public String getTimeOut(Integer id) {
        return "PaymentFallbackService fall back TimeOut!";
    }

    @Override
    public String paymentCircuitBreak(Integer id) {
        return "PaymentFallbackService fall back paymentCircuitBreak!";
    }
}
