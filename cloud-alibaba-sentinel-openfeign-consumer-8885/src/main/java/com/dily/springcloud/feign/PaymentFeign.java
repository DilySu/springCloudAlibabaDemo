package com.dily.springcloud.feign;

import com.dily.springcloud.feign.fallback.PaymentFallback;
import com.dily.springcloud.reponse.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Date: 2022-11-24 星期四
 * Time: 16:48
 * Author: Dily_Su
 * Remark:
 */
@FeignClient(value = "nacos-provider",fallback = PaymentFallback.class)
@Component
public interface PaymentFeign {
    @GetMapping("/payment/get/{id}")
    BaseResponse<?> getById(@PathVariable("id") Integer id);
}