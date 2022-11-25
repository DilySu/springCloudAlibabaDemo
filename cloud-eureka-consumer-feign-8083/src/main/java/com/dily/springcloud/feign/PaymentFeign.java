package com.dily.springcloud.feign;

import com.dily.springcloud.reponse.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Date: 2022-11-03 星期四
 * Time: 15:29
 * Author: Dily_Su
 * Remark:
 */
@FeignClient("cloud-payment")
@Component
public interface PaymentFeign {
    @GetMapping("/payment/get/{id}")
    BaseResponse<?> getById(@PathVariable("id") Long id);

    /**
     * 模拟被调服务响应时间需要3s
     */
    @GetMapping("/payment/timeout/lb")
    String getTimeOutLB ();
}
