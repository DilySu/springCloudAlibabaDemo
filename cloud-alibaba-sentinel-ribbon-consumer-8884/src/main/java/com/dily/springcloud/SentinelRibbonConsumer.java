package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Date: 2022-11-24 星期四
 * Time: 15:27
 * Author: Dily_Su
 * Remark:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelRibbonConsumer {
    public static void main(String[] args) {
        SpringApplication.run(SentinelRibbonConsumer.class, args);
    }
}
