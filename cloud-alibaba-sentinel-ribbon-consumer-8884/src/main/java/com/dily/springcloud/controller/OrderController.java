package com.dily.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dily.springcloud.entities.Payment;
import com.dily.springcloud.reponse.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Date: 2022-11-24 星期四
 * Time: 15:28
 * Author: Dily_Su
 * Remark: 服务消费者
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    public static final String SERVICE_URL = "http://sentinel-ribbon-provider";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/get/{id}")
//    @SentinelResource(value = "fallback", fallback = "handlerFallback") // 只配 fallback
//    @SentinelResource(value = "fallback", blockHandler = "blockHandlerMethod") // 只配 blockHandler
//    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandlerMethod") // blockHandler + fallback
    @SentinelResource(value = "fallback",
            fallback = "handlerFallback",
            blockHandler = "blockHandlerMethod",
            exceptionsToIgnore = {IllegalArgumentException.class}) // blockHandler + fallback + fallback 排除 IllegalArgumentException
    public BaseResponse getById(@PathVariable Integer id) {
        BaseResponse response = restTemplate.getForObject(SERVICE_URL + "/payment/get/" + id, BaseResponse.class);
        if (id == 4) {
            throw new IllegalArgumentException("非法参数异常");
        } else if (response.getData() == null) {
            throw new NullPointerException("该ID没有记录");
        }
        return response;
    }

    // fallback 兜底方法
    public BaseResponse handlerFallback(Integer id, Throwable e) {
        return new BaseResponse<>(444, "fallback 兜底异常:" + e.getMessage(), new Payment(id.longValue(), null));
    }

    // blockHandler 兜底方法
    public BaseResponse blockHandlerMethod(Integer id, BlockException e) {
        return new BaseResponse<>(444, "blockHandler 兜底异常:" + e.getMessage(), new Payment(id.longValue(), null));
    }
}
