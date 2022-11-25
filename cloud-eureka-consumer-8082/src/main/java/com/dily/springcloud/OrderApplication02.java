package com.dily.springcloud;

import com.dily.balanced.config.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Date: 2022-10-27 星期四
 * Time: 15:55
 * Author: Dily_Su
 * Remark:
 */
//@RibbonClient(value = "cloud-payment",configuration = MySelfRule.class)
@EnableEurekaClient
@SpringBootApplication
public class OrderApplication02 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication02.class, args);
    }
}
