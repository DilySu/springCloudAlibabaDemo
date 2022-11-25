package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Date: 2022-11-04 星期五
 * Time: 15:52
 * Author: Dily_Su
 * Remark:
 */
@EnableEurekaClient // 注册中心
@EnableFeignClients // 启用 feign
@EnableHystrix // 启用 熔断器
@SpringBootApplication
public class EurekaConsumerFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerFeignHystrixApplication.class, args);
    }
}
