package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Date: 2022-11-17 星期四
 * Time: 11:21
 * Author: Dily_Su
 * Remark:
 */
@EnableEurekaClient // 注册中心
@SpringBootApplication
public class EurekaConfigClientApplication01 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigClientApplication01.class, args);
    }
}
