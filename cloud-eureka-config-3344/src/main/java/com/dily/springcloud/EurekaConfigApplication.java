package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Date: 2022-11-16 星期三
 * Time: 16:05
 * Author: Dily_Su
 * Remark:
 */
@SpringBootApplication
@EnableConfigServer // 注册中心服务端
public class EurekaConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigApplication.class, args);
    }
}
