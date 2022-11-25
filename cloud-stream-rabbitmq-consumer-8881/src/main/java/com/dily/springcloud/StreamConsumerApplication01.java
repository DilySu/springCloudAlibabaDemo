package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Date: 2022-11-21 星期一
 * Time: 11:23
 * Author: Dily_Su
 * Remark:
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamConsumerApplication01 {
    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplication01.class, args);
    }
}
