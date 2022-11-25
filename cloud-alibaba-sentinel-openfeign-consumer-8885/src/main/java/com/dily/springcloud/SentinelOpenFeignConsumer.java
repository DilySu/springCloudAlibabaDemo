package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Date: 2022-11-24 星期四
 * Time: 16:44
 * Author: Dily_Su
 * Remark:
 */
@EnableFeignClients // 启用 feign 客户端
@SpringBootApplication
@EnableDiscoveryClient // 注册中心
public class SentinelOpenFeignConsumer {
    public static void main(String[] args) {
        SpringApplication.run(SentinelOpenFeignConsumer.class, args);
    }
}
