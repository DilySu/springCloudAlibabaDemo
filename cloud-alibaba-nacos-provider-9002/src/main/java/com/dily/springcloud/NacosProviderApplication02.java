package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Date: 2022-11-22 星期二
 * Time: 15:13
 * Author: Dily_Su
 * Remark:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class NacosProviderApplication02 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication02.class, args);
    }
}
