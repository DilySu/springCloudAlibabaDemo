package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Date: 2022-11-21 星期一
 * Time: 13:47
 * Author: Dily_Su
 * Remark:
 */
@EnableEurekaClient
@SpringBootApplication
public class StreamProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamProviderApplication.class, args);
    }
}
