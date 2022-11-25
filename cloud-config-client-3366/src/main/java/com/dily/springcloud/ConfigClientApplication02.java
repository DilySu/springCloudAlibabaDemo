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
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientApplication02 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication02.class, args);
    }
}
