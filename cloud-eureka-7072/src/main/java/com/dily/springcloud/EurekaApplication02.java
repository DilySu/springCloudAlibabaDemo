package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Date: 2022-10-27 星期四
 * Time: 16:43
 * Author: Dily_Su
 * Remark:
 */
@EnableEurekaServer // 注册中心服务端
@SpringBootApplication
public class EurekaApplication02 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication02.class, args);
    }
}
