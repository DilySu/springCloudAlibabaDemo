package com.dily.springcloud.feign.fallback;

import com.dily.springcloud.entities.Payment;
import com.dily.springcloud.feign.PaymentFeign;
import com.dily.springcloud.reponse.BaseResponse;
import org.springframework.stereotype.Component;

/**
 * Date: 2022-11-24 星期四
 * Time: 17:20
 * Author: Dily_Su
 * Remark: 备用方案
 */
@Component
public class PaymentFallback implements PaymentFeign {
    @Override
    public BaseResponse<?> getById(Integer id) {
        return new BaseResponse<>(444, "服务器繁忙", new Payment(id.longValue(), null));
    }
}
