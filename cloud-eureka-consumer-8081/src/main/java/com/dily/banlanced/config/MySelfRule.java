package com.dily.banlanced.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 2022-11-01 星期二
 * Time: 17:26
 * Author: Dily_Su
 * Remark:
 * 这个文件不可以在启动类同级目录下
 * 原因：IRule 不可在 @ComponentScan 注解所能扫描到的目录下
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }



}
