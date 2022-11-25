package com.dily.springcloud;

import com.dily.banlanced.config.MySelfRule;
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
//@RibbonClient(name = "cloud-payment",configuration = MySelfRule.class)  // 切换算法轮询策略时开启
@EnableEurekaClient
@SpringBootApplication
public class OrderApplication01 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication01.class, args);
    }
}
