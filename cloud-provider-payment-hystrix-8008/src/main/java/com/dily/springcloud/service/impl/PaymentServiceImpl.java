package com.dily.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.dily.springcloud.service.PaymentService;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Date: 2022-10-27 星期四
 * Time: 14:39
 * Author: Dily_Su
 * Remark:
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    //==================== 服务降级
    /**
     * 正常访问，一切OK
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_OK, id: " + id + "\t" + "O(∩_∩)O哈哈~";

    }

    /**
     * 正常访问，
     * 3s 内给出响应
     * 超时降级
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
//        int timeNumber = 10 / 0;
        int timeNumber = id * 100;
        try {
            TimeUnit.MILLISECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + "\t paymentInfo_TimeOut, id: " + id + "\t" + "O(∩_∩)O哈哈~,耗时" + timeNumber + "秒钟";

    }


    /**
     * 降级方案
     */
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "\t 系统繁忙，请稍后重试, id: " + id + "\t" + "/(ㄒoㄒ)/~~";
    }

    //==================== 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreak_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") // 失败率达到多少跳闸
    })
    public String paymentCircuitBreak(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数！");
        }
        String number = UUID.randomUUID().toString();
        return Thread.currentThread().getName() + "\t 调用成功，流水号：" + number;
    }

    public String paymentCircuitBreak_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数！请稍后重试！";
    }
}
