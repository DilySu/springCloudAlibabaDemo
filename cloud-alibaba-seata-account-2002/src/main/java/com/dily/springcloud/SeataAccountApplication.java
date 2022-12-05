package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Date: 2022-11-30 星期三
 * Time: 15:53
 * Author: Dily_Su
 * Remark:
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SeataAccountApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApplication.class, args);
    }
}
