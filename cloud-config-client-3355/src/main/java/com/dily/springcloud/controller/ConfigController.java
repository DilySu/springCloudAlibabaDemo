package com.dily.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 2022-11-17 星期四
 * Time: 13:37
 * Author: Dily_Su
 * Remark: 将配置中心的配置通过接口返回
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String port;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return port + ":\t" + configInfo;
    }
}
