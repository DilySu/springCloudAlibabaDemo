package com.dily.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Date: 2022-11-03 星期四
 * Time: 16:49
 * Author: Dily_Su
 * Remark:
 */
@Configuration
public class FeignConfig {
    @Bean // 配置 feign 日志登记
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
