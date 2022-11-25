package com.dily.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Date: 2022-10-27 星期四
 * Time: 15:55
 * Author: Dily_Su
 * Remark:
 */
//@RibbonClient(name = "cloud-payment",configuration = MySelfRule.class)  // 切换算法轮询策略时开启
@EnableEurekaClient // 注册中心
@SpringBootApplication
public class EurekaConsumerApplication01 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication01.class, args);
    }
}
