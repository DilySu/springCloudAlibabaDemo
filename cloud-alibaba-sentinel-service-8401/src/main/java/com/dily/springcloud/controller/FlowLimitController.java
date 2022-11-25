package com.dily.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * Date: 2022-11-23 星期三
 * Time: 14:40
 * Author: Dily_Su
 * Remark: 流量监控
 * 懒加载机制，只有被调用才会被监控
 */
@Slf4j
@RestController
@RequestMapping("FlowLimit")
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName());
        return "-----------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("-----------B");
        return "-----------testB";
    }


    @GetMapping("/testC/{id}")
    public String testC(@PathVariable Integer id) {
        log.info("-----------C");
        int i = 10 / id;
        return "-----------testC";
    }

    /**
     * 热点数据限流
     * @SentinelResource 类似于 @HystrixCommand
     * value：限流的资源名称，根据该值可在 sentinel 配置限流规则
     * blockHandler：用于热点限流，用于处理热点数据异常
     * fallback：
     */
    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey", blockHandler = "deal_hotKey")
    public String hotKey(@RequestParam(value = "p1", required = false) String p1,
                         @RequestParam(value = "p2", required = false) String p2) {

        return "----------------hotKey";
    }

    public String deal_hotKey(String p1, String p2, BlockException exception) {
        // sentinel 默认提示 Blocked by sentinel (flow limiting)
        return "----------deal_hotKey!!!";
    }
}
