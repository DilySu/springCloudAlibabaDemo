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
@EnableDiscoveryClient // 注册中心客户端
@SpringBootApplication
public class NacosProviderApplication01 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication01.class, args);
    }
}
