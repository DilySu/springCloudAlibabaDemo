package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Date: 2022-11-23 星期三
 * Time: 14:31
 * Author: Dily_Su
 * Remark:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SentinelServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceApplication.class, args);
    }
}
