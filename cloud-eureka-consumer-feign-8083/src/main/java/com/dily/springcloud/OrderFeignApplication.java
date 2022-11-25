package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Date: 2022-11-03 星期四
 * Time: 15:26
 * Author: Dily_Su
 * Remark:
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class OrderFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignApplication.class, args);
    }
}
