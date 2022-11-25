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
//@RibbonClient(value = "cloud-payment",configuration = MySelfRule.class)
@EnableEurekaClient
@SpringBootApplication
public class EurekaConsumerApplication02 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication02.class, args);
    }
}
