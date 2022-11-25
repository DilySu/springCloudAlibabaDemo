package com.dily.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Date: 2022-10-27 星期四
 * Time: 16:01
 * Author: Dily_Su
 * Remark:
 * nacos 中继承了 ribbon 所以支持负载均衡
 */
@Configuration
public class AutoConfig {

    @Bean
    @LoadBalanced // 默认轮询
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
