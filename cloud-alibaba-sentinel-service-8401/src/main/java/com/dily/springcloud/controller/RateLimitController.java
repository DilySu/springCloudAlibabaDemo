package com.dily.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dily.springcloud.entities.Payment;
import com.dily.springcloud.handler.CustomerBlockHandler;
import com.dily.springcloud.reponse.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Date: 2022-11-24 星期四
 * Time: 14:38
 * Author: Dily_Su
 * Remark:
 */
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public BaseResponse byResource() {

        return new BaseResponse<>(200, "按资源名称限流，OK", new Payment(2022L, UUID.randomUUID().toString()));
    }

    public BaseResponse handleException(BlockException e) {
        return new BaseResponse<>(444, e.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public BaseResponse byUrl() {
        return new BaseResponse<>(200, "按 URL 限流，OK", new Payment(2022L, UUID.randomUUID().toString()));
    }

    // 客户端统一处理 customerBlockHandler
    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public BaseResponse customerBlockHandler() {
        return new BaseResponse<>(200, "customerBlockHandler 限流，OK", new Payment(2022L, UUID.randomUUID().toString()));
    }
}
