package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Date: 2022-10-31 星期一
 * Time: 10:06
 * Author: Dily_Su
 * Remark:
 */

@EnableEurekaServer // 注册中心服务端
@SpringBootApplication
public class EurekaApplication01 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication01.class, args);
    }
}
