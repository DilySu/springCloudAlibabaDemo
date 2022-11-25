package com.dily.balanced.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 2022-11-01 星期二
 * Time: 17:26
 * Author: Dily_Su
 * Remark: 自定义负载均衡策略
 */
@Configuration
public class MySelfRule {
    @Bean // 负载均衡策略
    public IRule myRule() {
        return new RandomRule();
    }


    
}
